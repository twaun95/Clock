# Clock

|  배경 색상 변경 | 펜 색상 변경 | 3333 |
|:----------:|:----------:|:----------:|
| <video src="https://user-images.githubusercontent.com/43190509/194698121-90888c14-cd7d-4026-bf38-9216af19e129.mp4" width="200" height="400" /> | <video src="https://user-images.githubusercontent.com/43190509/194698128-23766df5-7c50-4c94-a52a-53deaa7e42e7.mp4" width="200" height="400"/> | <video src="https://user-images.githubusercontent.com/43190509/194698138-f463dc06-74e4-40d4-b4f7-b17242df2198.mp4" width="200" height="400"/> |


여러 기능의 시계들(타이머, 스톱워치, 푸시알람)을 사용해보세요.

## 타이머

<img src="https://user-images.githubusercontent.com/43190509/194486005-78bcf435-8109-4639-a6d3-4446d4b674fa.gif" width="200" height="400"/>

사용 방법
1. 타이머 시간을 선택하세요.
2. 시작하면 설정한 시간만큼 타이머가 작동합니다.
3. 시간이 종료되면 진동이 울립니다.
4. 확인하면 진동이 멈춥니다.

## 스톱워치

<img src="https://user-images.githubusercontent.com/43190509/194495468-12f12889-1c77-4e4d-8a22-f6f4cc0bd8f0.gif" width="200" height="400"/>

사용 방법
1. 시작버튼을 누르면 스톱워치 시간이 흘러갑니다.
2. 계속/중지 로 시간을 멈추고 진행할 수 있습니다.
3. 시간 진행 중에는 기록을 할 수 있고 화면에서 기록 시간을 확인할 수 있습니다.
4. 시간 중지 중에는 초기화를 해서 시간과 기록을 모두 처음으로 되돌립니다.

## 푸시알람

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
- BroadCast
- DataBinding
- LiveData
- Vibrator


- AlarmManager
- NotificationManager
- Timer
- ProgressBar, BottomNavigation, TimePicker


### 타이머
- 타이머 시간 선택 : NumberPicker
- 타이머 시각화 : Custom ProgressBar
- 시간 컨트롤 : Timer
- 타이머 종료 시 : Lottie & Vibrator

### 스톱워치
- 시간 컨트롤 : Timer
- 구간 기록 : RecyclerView
- 시작 / 정지 / 기록 / 초기화

### 푸시알람

- 알람 시간 선택 : TimerPicker
- 알림 안내 : Custom Toast
- 알람 : AlarmManager & NotificationManager

+)
처음에는 FCM(Firebase Cloud Messaging)을 사용하려 했으나 정확한 시간에 알림을 받을 필요가 있기 때문에 
서버를 통하는 FCM 보다 로컬에 시간을 등록하는 AlarmManager 가 더 적합하다고 생각했다.



# Environment
- Android Studio Chipmunk 2021.2.1
- minSdkVersion 29
- targetSdkVersion 32
- Test Device - Galaxy S10e
