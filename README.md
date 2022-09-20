# clock
(진행중)
시계(푸시알람, 스톱워치, 타이머)


## 사용 기술
- MVVM
- Koin
- Navigation
- BroadCast
- AlarmManager
- Notification
- Timer
- TimerPicker, NumberPicker
- ProgressBar
- BindingAdapter

### 1. 알람(푸시알람)

- 알람 시간 선택 (TimerPicker)
- FCM(FireBase Cloud Messaging -> Notification & AlamManager 로 변경

FCM은 서버와 연동해서 사용하는 것이 좋다고 판단.
알람 등록은 서버가 아닌 로컬에서 관리해야 시간 동기화가 될 것 같다..

### 2. 스톱워치
- Timer
- 시작/정지
- 초기화
- 랩 기록(Recycler View)

### 3. 타이머
- AlarmManager
- 타이머 시각화(Progress bar)
- 시간(분/초) 선택 -> 설정 시간이 다되면 알람 소리 울리기
- 시적/정지


