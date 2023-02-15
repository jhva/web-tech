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