package work6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/**
 * @author:LXY
 * @className:Account
 * @description:
 * @date:2021/3/2920:20
 * @version:0.1
 * @since:1.8
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private long id;
    private Double balance;
    private String password;
    public Account(Double balance, String password) {
        this.balance = balance;
        this.password = password;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getId() == account.getId() &&
                Objects.equals(getBalance(), account.getBalance()) &&
                Objects.equals(getPassword(), account.getPassword());
    }
    @Override
    public int hashCode() {

        return Objects.hash(getId(), getBalance(), getPassword());
    }
    public static void main(String[] args) {
        ArrayList<Account> list=new ArrayList();
        list.add(new Account(10.00,"1234"));
        list.add(new Account(15.00,"5678"));
        list.add(new Account(0.00,"1010"));
        HashMap map=new HashMap();
        for(Integer index=0;index<list.size();index++){
            list.get(index).setId(index+1);
            map.put(list.get(index).getId(),list.get(index));
        }
        for(Object obj:map.values()){
            //Account account=(Account)obj;
           // System.out.println(obj);
            System.out.println("用户id为："+((Account) obj).getId()+"用余额为："+((Account) obj).getBalance());

        }
//        Set set=map.keySet();
//        Collection<Account> coll=map.values();
//        System.out.println(coll);

//       Iterator iterator2=coll.iterator();
////        Iterator iterator1=set.iterator();
//        while(iterator2.hasNext()){
//            System.out.println(coll.iterator().next().balance);
//        }
//        Iterator iterator=list.iterator();
//        while(list.iterator().hasNext()){
//            (Account)iterator.next().
//            map.put(iterator.next())
        }
    }




