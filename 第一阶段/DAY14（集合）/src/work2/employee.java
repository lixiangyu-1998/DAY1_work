package work2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * @author:LXY
 * @className:employee
 * @description:
 * @date:2021/3/2713:09
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public  abstract class employee {
    private String name;
    private int id;
    private int age;
    public abstract void show();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof employee)) return false;
        employee employee = (employee) o;
        return getId() == employee.getId() &&
                getAge() == employee.getAge() &&
                Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getId(), getAge());
    }
}

