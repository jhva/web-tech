# 연관관계의 매핑

- 방향
    - 단방향
        - 관계상의 두 객체 가 둘 중 한쪽만 참조하는 것을 단방향 관계라고한다.
    - 다중성
        - 다대일
        - 일대다
        - 일대일
        - 다대다
    - 연관관계의 주인

### 객체 연관관계와 테이블 연관관계의 가장 큰차이

- 참조를 통한 언제나 단방향인데 객체간에 연관관계를 양방향으로 만들고 싶으면 반대쪽에도 필드를 추가해서 참조를 보내야하는데
  이것을 양방향 관계가아니라 서로 다른 단방향 관계 2개라고 의미를함.

```
//단방향일때 

class A{
    B b;
};
Class B{};
----
// 양방향일때         
Class A{
  B b;
}
Clsss B{
  A a;
}
```

- 객체는 참조로 연관관계를 맺고 . 중요
- 테이블은 외래키로 연관관계를 맺음 .

```

     Member member = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");

        Team tema = new Team("team1", "팀1");


        member.setTeam(tema);
        member2.setTeam(tema);

        Team findTeam = member.getTeam();
        Team findTeam2 = member2.getTeam();
        System.out.println(findTeam==findTeam2);

```

- 순수하게 짯을때 object를 equals 로 확인해봤을때 True가 나온다 그이유는 ? 같은 Team을 바라보고있기때문이다 .
    - 이렇게 참조를 사용해서 연관관계를 탐색할 수 있는데 이걸 객체그래프 탐색이라함

### 객체 그래프 탐색이란 ?

> 객체에서 참조된 팀을 조회하면서 찾을때 이것을 객체 그래프 탐색이라함

### @JoinColumn(name = "Team_ID)

- 조인 컬럼은 외래키를 매핑할 때 사용함
- 주요 속성 정리
    - foreignKey : 외래 키 제약조건을 직접 지정할 수있고, 이 속성은 테이블을 생성할 때만 사용함.
    - referencedColumnName : 외래 키가 참조하는 대상 테이블의 컬럼명

## @OneToMany(mappedBy)

> 연관관계의 주인

- 양방향 매핑일 때 사용하는데, 반대쪽 매핑의 필드 이름을 값으로 주면된다 .
- 주인은 FK(외래키)가 명시된 Entity클래스로 설정합니다
    - 반대로 연관관계의 주인이 아닌쪽은 읽기만 할 수 있다 .

### 상속 관계 매핑

> 객체의 상속 관계시 데이터베이스에 어떻게 매핑하느지 .

- @MappedSuperClass
    - 등록일, 수정일 같이 여러 엔티티에서 공통으로 사용하는 매핑 정보만 상속받고 싶으면 이 기능을 사용하면 됨
- @Inheritance (strategy=InheritanceType.JOINED)
    - 상속 매핑은 부모 클래스에 @Inheritance를 사용해야함.
- @DiscriminatorColumn(name="DTYPE")
    - 부모 클래스에 구분 컬럼을 지정함 . 이컬럼으로 저장된 자식 테이블을 구분할수있음
- @DiscriminatorValue("M")
    - 엔티티를 저장할 대 구분 컬럼에 입력할 값을 지정함. 만약 영화 엔티티를 저장하면 구분 컬럼인 DTYPE에 값 M이 저장됨 .

### 단일 테이블 전략

- @InheritanceType.SINGLE_TABLE
    - 테이블 하나에 모든 것을 통합하므로 구분 컬럼을 필수로 사용해야함 단일 테이블의 전략의 장단점은 하나의 테이블을 사용하는 특징과관련잉있음.
- @DiscrimnatorColumn
    - 구분 컬럼을 꼭 사용해야한다.
- 자식엔티티는 @DiscriminatorValue를 꼭 붙여서 사용을 한다. 안그러면 그냥 기본 엔티티 이름으로 사용이된다 .
- 장점
    - 조인이 필요없다. 일반적으로 조회가빠르다. 조회쿼리가 단순하다.
- 단점
    - 자식 엔ㅁ티티가 매핑한 컬럼은 모두 null허용해야함
    - 자식 테이블에 대한 모든 것을 저장해서 테이블이 커지면 상황에 따라서는 조회 성능이 오히려 느려진다 .

### 구현 클래스마다 테이블 전략

> 구분 컬럼을 사용하지 않는다.

- @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
- 장점
    - 서브 타입을 구분해서 처리할 대 효과적이다 .
    - not null 제약조건을 사용할 수 있다.
- 단점
    - 여러 자식 테이블을 함께 조회할때 성능이 느리다 (SQL에 유니온을 사용해야함)
    - 자식 테이블을 통합해서 쿼리하기 가 어렵다

### @MappedSuperClass

> 컬럼을 사용할때 부모에게서 받은 값들을 재정의하고싶을때

- @AttributeOverrides
- @AttributeOverride

```java
@Entity
@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID"))


@Entity
@AttirbuteOverrides({
        @AttirbuteOverride(name = "id", column = @Column(name = "MEMBER_ID")),
        @AttirbuteOverride(name = "name", column = @Column(name = "MEMBER_NAME")),
})
```

### 복합 키와 식별 관계 매핑

- 식별관계
    - 식별 관계는 ㅁ부모 테이블의 기본 키를 내려받아서 자식 테이블의 <b>기본 키 + 외래 키 </b>로 사용하는 관계다 .
   ```

  parent child
  parentid pk,fk
  childid pk
  name 

  ```
- 비식별관계
    - 부모 테이블의 기본키를 받아서 자식 테이블의 외래 키로만 사용하는 관계

```
parent          child
parentid pk     childid pk
parentid (fk)
name            name

```

- 필수적 비식별 관계
    - 외래키에 NULL을 허용하지 않음. 연관관계를 필수적으로 맺어야함.
- 선택적 비식별 관계
    - 외래 키의 null을 허용한다. 연관계를 맺을지 말지 선 택가능 



#