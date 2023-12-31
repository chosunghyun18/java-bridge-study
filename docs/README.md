
## 🚀 기능 요구 사항

### InputView & InputValidate 클래스

#### 입력

- [x] 자동으로 생성할 다리 길이를 입력 받는다.
  - [x] 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

- [x] 라운드마다 플레이어가 이동할 칸을 입력 받는다.
- [x] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

- [x] 게임 재시작/종료 여부를 입력 받는다.
- [x] R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

#### controller

### InputController

- 사용자 입력을 제어 한다.
- 잘못 된 입력을 받을 시 사용자로 부터 재 입력을 받는다 .

### BridgeGame 클래스
- [x] 게임의 사용할 다리를 생성 저장한다.
- [x] 다리 이동을 입력 받고 저장을 한다.
- [x] 게임 재시작 여부를 확인한다.
- [x] 유저의 게임 데이터를 생성 한다.
-


### BridgeMaker 클래스
- [x] 숫 자를 입력 받으면  1 이면 U ,  0 이면 D 를 가지는  배열을 반환한다.


### OutputView 클래스

#### 출력

- [x] 게임 시작 메시지를 출력한다.

```
다리 건너기 게임을 시작합니다.
```

- [x] 다리 길이 입력 메시지를 출력한다.

```
다리의 길이를 입력해주세요.
```

- [x] 이동할 칸의 입력 안내 메시지를 출력한다.
```
이동할 칸을 선택해주세요. (위: U, 아래: D)
```
- [x] 다리를 출력 한다.

- [x] 게임 재시작 여부 안내 메시지를 출력 한다.
게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)

- [x] 게임 최종 결과를 출력한다.
```
최종 게임 결과
[ O | X ]
[   |   ]

게임 성공 여부: 실패
총 시도한 횟수: 1
```