package com.example;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalcTest {
static Calc calc = null;
@BeforeAll
static void テスト前処理() {
calc = new Calc();
}
@Test
void addテスト_正常() {
assertEquals(calc.add(1, 3), 4);
assertThat(calc.add(1, 3))
.as("加算結果の確認")
.isEqualTo(3);
}

@Test
void subテスト_正常() {
    assertEquals(calc.sub(10,1),9);
    assertThat(calc.sub(10,1))
    .as("減算結果の確認")
    .isEqualTo(9);
}

@Test
void divテスト_正常() {
    assertEquals(calc.div(9,3),3);
    assertThat(calc.div(9,3))
    .as("除算結果の確認")
    .isEqualTo(3);
}

@Test
void mulテスト_正常() {
    assertEquals(calc.mul(2,3),6);
    assertThat(calc.mul(2,3))
    .as("乗算結果の確認")
    .isEqualTo(6);
}

@Test
void  divテスト_異常() {
    assertThatThrownBy(() -> calc.div(10, 0))
    .isInstanceOf(ArithmeticException.class)
    .hasMessageContaining("by zero");
}

@AfterAll
static void テスト後処理() {
calc = null;
}
}