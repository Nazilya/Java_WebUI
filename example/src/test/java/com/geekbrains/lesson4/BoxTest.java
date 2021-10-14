package com.geekbrains.lesson4;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class BoxTest {
    Box box;

    @Nested
    class WhenIsEmpty {
        @BeforeEach
        void createBox() {
            box = new Box();
        }
        @Test
        @Description("Добавить мяч в коробку")
        void addBallTest() {
            box.addBall();
            Assertions.assertEquals(1, box.getBallsCounter());
        }
        @Test
        @Description("Удалить мяч из пустой коробки")
        void removeBallFromEmptyBoxTest() {
            //assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> box.removeBall());
            assertThatNullPointerException().isThrownBy(() -> box.removeBall());
        }
        @Test
        @Description("Перемешать мячи в коробке")
        void shuffleEmptyBoxTest() {
            assertThatExceptionOfType(BoxIsEmptyException.class).isThrownBy(() -> box.shuffleBalls());
        }
        @Nested
        class WhenWithBalls {
            @BeforeEach
            void addBalls() {
                box.addBall();
            }
            @Test
            @Description("Удалить мяч из коробки с мячами")
            void removeBallFromBoxWithBalls(){
                box.removeBall();
                assertThat(box.getBallsCounter()).isEqualTo(0);
            }
        }
    }

}
