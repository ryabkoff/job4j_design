package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void whenBoxIsSphereThenVertexEqualTo0() {
        Box box = new Box(0, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(0);
    }

    @Test
    void whenBoxIsTetrahedronThenVertexEqualTo4() {
        Box box = new Box(4, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4);
    }

    @Test
    void whenObjectIsntExist() {
        Box box = new Box(12, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isFalse();
    }

    @Test
    void whenObjectIsExist() {
        Box box = new Box(4, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isTrue();
    }

    @Test
    void testSphereArea() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(1256.64d, withPrecision(0.01d));
    }

    @Test
    void testCubeArea() {
        Box box = new Box(6, 1);
        double area = box.getArea();
        assertThat(area).isEqualTo(6);
    }
}