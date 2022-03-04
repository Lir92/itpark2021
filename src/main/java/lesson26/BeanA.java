package lesson26;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@RequiredArgsConstructor
public class BeanA {

    private BeanB bean;

    public void print() {
        System.out.println(bean);
    }
}
