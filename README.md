# Clock

여러 기능 시계(타이머, 스톱워치, 푸시알람)를 사용해보세요.

### 타이머

<img src="https://user-images.githubusercontent.com/43190509/194486005-78bcf435-8109-4639-a6d3-4446d4b674fa.gif" width="200" height="400"/>

사용 방법
1. 타이머 시간을 선택하세요.
2. 시작하면 설정한 시간만큼 타이머가 작동합니다.
3. 시간이 종료되면 진동이 울립니다.
4. 확인하면 진동이 멈춥니다.

### 스톱워치

<img src="https://user-images.githubusercontent.com/43190509/194495468-12f12889-1c77-4e4d-8a22-f6f4cc0bd8f0.gif" width="200" height="400"/>

사용 방법
1. 시작버튼을 누르면 스톱워치 시간이 흘러갑니다.
2. 계속/중지 로 시간을 멈추고 진행할 수 있습니다.
3. 시간 진행 중에는 기록을 할 수 있고 화면에서 기록 시간을 확인할 수 있습니다.
4. 시간 중지 중에는 초기화를 해서 시간과 기록을 모두 처음으로 되돌립니다.

### 푸시알람

<img src="https://user-images.githubusercontent.com/43190509/194491902-5904a78b-1243-4b47-94c9-d57b20e8e81f.gif" width="200" height="400"/>

사용 방법
1. 알람시간을 선택하세요.
2. 등록버튼을 누르면 토스트를 통해 등록 시간을 다시 한번 알립니다.
3. 알람 시간에 푸시알람이 도착합니다.
4. 푸시알람을 클릭하면 앱을 실행합니다.

# Structure

<pre>
.app/
  &boxvr;&boxh;&boxh; common
  &boxur;&boxh;&boxh; di (koin)
  &boxv;      &boxvr;&boxh;&boxh; HandlerModule
  &boxv;      &boxur;&boxh;&boxh; ViewModelModule
  &boxur;&boxh;&boxh; handler
  &boxv;      &boxvr;&boxh;&boxh; PushAlarmHandler
  &boxv;      &boxvr;&boxh;&boxh; PushAlarmReceiver
  &boxv;      &boxur;&boxh;&boxh; VibrationHandler
  &boxur;&boxh;&boxh; presentation
        &boxvr;&boxh;&boxh; adapter
        &boxv;      &boxvr;&boxh;&boxh; BindingAdapter
        &boxv;      &boxur;&boxh;&boxh; RecyclerViewAdapter
        &boxvr;&boxh;&boxh; extensions
        &boxvr;&boxh;&boxh; models
        &boxur;&boxh;&boxh; utils
        &boxv;      &boxur;&boxh;&boxh; Toast
        &boxur;&boxh;&boxh; view (Custom View)
        &boxv;      &boxur;&boxh;&boxh; StopWatchText
        &boxur;&boxh;&boxh; ui
              &boxvr;&boxh;&boxh; main (Activity, ViewModel)
              &boxvr;&boxh;&boxh; alarm (Fragment, ViewModel)
              &boxvr;&boxh;&boxh; stopwatch (Fragment, ViewModel)
              &boxur;&boxh;&boxh; timer (Fragment, ViewModel)
  
</pre>


# Skills
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


# Environment
