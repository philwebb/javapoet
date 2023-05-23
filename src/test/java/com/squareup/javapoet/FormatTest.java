package com.squareup.javapoet;

import java.io.IOException;
import java.util.Collections;

import javax.lang.model.element.Modifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.squareup.javapoet.TypeSpec.Builder;

@RunWith(JUnit4.class)
public class FormatTest {

  @Test
  public void test() throws IOException {
    TypeSpec.Builder typeSpec = TypeSpec.classBuilder("Taco");
    typeSpec.addField(String.class, "foo", Modifier.PRIVATE);
    typeSpec.addField(String.class, "bar", Modifier.PRIVATE);
    typeSpec.addField(String.class, "FOO", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL);
    typeSpec.addField(String.class, "BAR", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL);
    typeSpec.addStaticBlock(CodeBlock.builder().addStatement("FOO = $S", "FOO").build());
    typeSpec.addStaticBlock(CodeBlock.builder().addStatement("BAR = $S", "BAR").build());
    typeSpec.addMethod(MethodSpec.methodBuilder("toString").addAnnotation(Override.class).addModifiers(Modifier.PUBLIC)
        .returns(String.class).addCode("return FOO;\n").build());
    TypeSpec taco = typeSpec.build();
    StringBuilder out = new StringBuilder();
    CodeWriter codeWriter = new CodeWriter(out, Formatting.DEFAULT, Collections.emptySet(), Collections.emptySet());
    taco.emit(codeWriter, null, Collections.emptySet());
    System.out.println(out.toString());
  }

}
