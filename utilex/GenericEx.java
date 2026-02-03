package test.utilex;

/*
 * Generic: 필드의 타입을 생성시에 지정하여 대입하도록 하는 것
 */

class Box <T> {   // 이 객체의 필드의 타입을 결정하도록 하는 키워드 T를 선언한다.
   // T는 type의 키워드로 그냥 문자에 지나지 않음.. A~Z까지 쓰고 싶은 거 써도 됨
   // 단 T가 Type으로 이해되기 가장 쉽기 때문에 T를 사용함
   // 또, 이렇게 타입을 지정하면 내부의 컨텐츠는 반드시 클래스나 인터페이스 타입이어야 함
   // 즉, 객체 타입이라는 뜻.. P type은 wrapping 되어서 써야 함
   // Box를 만들 때, content의 타입을 미리 결정하겠다
   // 나중에 타입 들어올 자리만 만들어 둔 상태임
   public T content;   
}

class GiftBox <T> {
   private T t;
   
   public T get() {
      return t;
   }
   public void setT(T t) {
      this.t = t;
   }
}

class Product <K,M> {
   private K kind;
   private M model;
   
   // “나중에 어떤 타입이 들어올 건데, 그 타입을 그대로 넣고 그대로 꺼내주는 메서드”
   // 이 getter/setter는 그냥 값 넣고 빼는 게 아니라 "객체를 생성할 때 정해진 타입을 그대로 유지해주는 통로 역할"을 하는 메서드
   public K getKind() {
      return kind;
   }
   public void setKind(K kind) {
      this.kind = kind;
   }
   public M getModel() {
      return model;
   }
   public void setModel(M model) {
      this.model = model;
   }
}

class Tv{
   
}

class Car{
   public void run() {
      System.out.println("자동차가 달립니다.");
   }
}

// 이번에는 상품을 렌트하도록 하는 인터페이스를 정의할거임
// 어떤 상품을 렌트할지는 타입 결정에 따른다
interface Rentable <P> {
   P rent();
}   // "어떤 타입의 물건을 빌려줄지는 나중에 결정하겠다"는 의미. P = 빌려줄 상품의 타입

class Home {
   public void turnOnLight() {
      System.out.println("전등을 켬");
   }
}

// 위 인터페이스를 구현한 클래스를 정의하고, 이 클래스의 메서드를 이용해서 rent()를 수행하자
class HomeAgency implements Rentable <Home> {   // Rentable<P>에서 P를 Home으로 결정
   @Override
   public Home rent() {
      return new Home();
   }
}

// 자동차를 렌트한다
class CarAgency implements Rentable <Car> {      // 여기서는 P = Car
   @Override
   public Car rent() {
      return new Car();
   }
}

/*
 * 제한된 타입의 파라미터 처리하는 법..
 * 이 내용은 특정 파라미터가 특정 타입의 하위 타입으로만 제한을 시킬 때 많이 사용함
 * 즉, 파라미터가 특정 타입의 하위 타입이거나, 구현된 타입으로만 제한시켜 대입되도록 하는 데 목적이 있다
 * ex) public <T extends SuperType> 리턴타입 메서드명(파라미터)
 */

public class GenericEx {
   
   // 제한된 메서드 타입 파라미터를 갖는 제네릭 메서드 정의
   public static <T extends Number> boolean compare(T t1, T t2) {      // T는 Number를 상속한 타입만 가능
      // T의 타입을 출력한다
      System.out.println("compare" + t1.getClass().getSimpleName() + " , " +
            t2.getClass().getSimpleName() + ")");
      // t1.getClass(): 실제 들어온 객체의 타입을 알려줌
      
      double v1 = t1.doubleValue();
      double v2 = t2.doubleValue();
      
      return(v1 == v2);
   }
   
   
   // 제네릭 메서드를 구현시엔 <T>타입<T> 형태로 선언해야 한다.
   public static <T>GiftBox<T> boxing(T t) {   // 어떤 타입이 들어오든, 그 타입을 가진 GiftBox를 만들어서 반환
      GiftBox<T> box = new GiftBox<T>();   // “들어온 타입 그대로 GiftBox에 담아서 돌려주는 메서드”
      box.setT(t);
      return box;
   }

   public static void main(String[] args) {
      
      //제네릭 메서드 호출
      boolean result1 = compare(10, 20);
      System.out.println(result1);
      System.out.println();
      
      boolean result2 = compare(4.5, 4.5);
      System.out.println(result2);
      
      
      GiftBox<Integer> gbox1 = boxing(100);
      int value = gbox1.get();
      System.out.println(value);
      
      GiftBox<String> gbox2 = boxing("홍길동");
      String strValue = gbox2.get();
      System.out.println(strValue);
      
      
      HomeAgency homeagency = new HomeAgency();
      Home home = homeagency.rent();   // 컴파일러는 이미 homeagency.rent() 는 Home을 리턴한다는 걸 앎
      home.turnOnLight();
      
      CarAgency carAgency = new CarAgency();
      Car car = carAgency.rent();
      car.run();
      
      
      // TV를 product의 필드값으로 세팅시에 제네릭을 이용한다.
      Product <Tv, String> product1 = new Product();
      // 위 줄이 실행되는 순간, 컴파일러는 머릿속에서
      // private Tv kind; private String model; 이렇게 바꿔버림.
      product1.setKind(new Tv());
      product1.setModel("스마트티비");
      
      // 세팅된 제네릭 필드를 get
      Tv tv = product1.getKind();
      String tvMode = product1.getModel();
      
      Product <Car, String> product2 = new Product();
      product2.setKind(new Car());
      product2.setModel("SUV 자동차");
      
      Car car1 = product2.getKind();
      String carMode = product2.getModel();
      
      
      Box<String> box1 = new Box();
      // 위 줄이 실행되는 순간, 컴파일러는 머릿속에서 
      // class Box { public String content; } 이렇게 바꿔버림.
      // 그래서 이제부터 이 box는 String 전용 박스가 됨
      box1.content = "안녕하세요";
      String str = box1.content; // 형변형 없이 get
      System.out.println(str);
      
      Box<Integer> box2 = new Box();
      box2.content = 100;
      int value1 = box2.content; // 형변형 없이 get
      System.out.println(value1);
   }
}