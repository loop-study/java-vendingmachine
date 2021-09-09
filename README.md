## 요구 사항
- [x] 입력된 금액으로 동전 무작위 생성
  - [x] 동전은 500원, 100원, 50원, 10원 4가지로 구성됨.
  - [x] 동전은 투입 금액내에서 랜덤 생성
  - [x] 생성 후 잔액이 남아있다면 남은 잔액으로 재실행
 
- [x] 사용자가 자판기에 금액을 투입한다.
  - [x] 100원 이상 입력받는다.
  - [x] 투입 금액은 10원 단위이다.
 
- [x] 입력된 상품 정보([상품명,개수,금액])로 상품을 생성한다
  - [x] 개수는 0개 이상이여야 한다.
  - [x] 상품 금액은 100원 이상이다.
  - [x] 상품 금액은 10원 단위이다.
  - [x] 여러 상품을 구분은 기호 ; 를 사용한다. ex) [콜라,20,1500];[사이다,15,1000]
  
- [x] 상품을 구매한다 
  - [x] 상품명을 입력하여 구매한다. ex) 콜라
  - [x] 상품 개수는 하나씩 차감한다.
  - [x] 상품 개수가 0개가 되면 구매할 수 없다고 노출한다.
  - [x] 상품보다 잔액이 부족하면 구매할 수 없다고 노출한다.
  
- [x] 자판기 이용을 종료한다.
  - [x] 상품의 최소 금액보다 낮으면 자동으로 종료한다.
  - [x] 상품이 다 팔리면 자동으로 종료한다.
  - [x] 잔돈 반환 시에 가지고 있는 동전 최소 개수의 동전으로 돌려준다.
  - [x] 잔액이 잔돈보다 많을 경우 잔돈 모두를 돌려주고 끝낸다.