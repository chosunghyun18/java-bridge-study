# 기능 목록

## Application
* Main Program 실행 클래스
### 기능 목록
* BridgeController 클래스를 생성하고 실행

## BridgeController
* Controller Class
### 기능 목록
* View(InputView, OutputView)와 Model(BridgeGame)간의 상호작용 조율
  * Size, Moving, GameCommand를 InputView에서 입력받아 BridgeGame에 전달
  * BridgeGame에서 Map, 게임결과, 시도횟수를 전달받아 OutputView에 전달
* 게임 진행
* 예외 발생 시에 OutputView를 통해 예외 문구를 출력시키고 다시 게임을 진행

## BridgeGame
* 다리 게임 클래스
* 다리 게임에 대한 정보를 보유
## 기능 목록
* 유저의 입력대로 위 또는 아래로 움직이는 기능(현재 상태의 지도에 플레이어의 움직임에 따른 새로운 칸 추가)
* 게임을 재시작하는 기능(현재 상태의 지도를 초기화)

## BridgeMaker
* 다리 제작 클래스
## 기능 목록
* Size를 받아 다리를 제작하여 반환
### 관련 클래스
#### BridgeNumberGenerator
* 다리 제작을 위한 Interface
#### BridgeRandomNumberGenerator
* 다리 제작을 위한 무작위 정수(0,1) 생성기

## ArgumentError
* 에러 처리 클래스
### 기능 목록
* Size가 숫자로만 이루어져 있는지 확인하고, 아니라면 IllegalArgumentException 발생
* Size가 3 이상 20 이하인지 확인하고, 아니라면 IllegalArgumentException 발생
* moving이 U 또는 D 인지 확인하고, 아니라면 IllegalArgumentException 발생
* gameCommand가 R 또는 Q 인지 확인하고, IllegalArgumentException 발생

## InputView
* 입력 View 클래스
### 기능 목록
* size, moving, gameCommand를 입력받아 전달한다.

## OutputView
* 출력 View 클래스
### 기능 목록
* 다리 게임의 현재 지도, 결과 지도, 게임 결과, 시도 횟수를 출력한다.

## Result
* 성공, 실패를 나타내는 Enum 클래스
* OutputView에서 사용

## Row
* 1번째 줄, 2번째 줄을 나타내는 Enum 클래스
* OutputView에서 사용

## ListTransformer
* 출력을 위해 map의 형태를 가공하는 클래스
### 기능 목록
* size, 2 형태의 리스트를 2, size 형태로 변환하여 반환