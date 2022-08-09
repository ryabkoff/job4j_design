package ru.job4j.ood.ocp.example2;

public class Repository {
    /*
    Есть иерархия объектов с абстрактным родительским классом AbstractEntity
    и класс Repository, который использует абстракцию.
    При этом вызывая метод Save у Repository мы строим логику в зависимости
    от типа входного параметра. Из кода видно, что объект Repository придется
    менять каждый раз, когда мы добавляем в иерархию объектов с базовым классом
    AbstractEntity новых наследников или удаляем существующих.
    Условные операторы будут множится в методе Save и тем самым усложнять его.
     */
    public void save(AbstractEntity entity) {
        if (entity instanceof AccountEntity) {
            System.out.println("Using AccountEntity");
        }
        if (entity instanceof RoleEntity) {
            System.out.println("Using RoleEntity");
        }
    }
}
