# ActiveMQ Boot & Receiver
> 타이틀은 거창하지만 Topic 과 Queue 를 구성하고, 메시지를 받는 기능을 수행하는 심플한 녀석이다

현재 상태는 ActiveMQ 는 Brew 통해서 설치하고, 실행된 상태이다.  
두 개의 Spring Boot 모듈이 존재한다.

## 구조
 - **module-boot**
   - Queue, Topic 으로 메시지를 전송하는 기능과 리시버를 포함한다.
     - `/sendQueue`  
        메시지를 Queue 로 전송한다.
     - `/sendTopic`  
        메시지를 Topic 으로 전송한다.
 - **module-receiver**
   - 나는 리시버 이다.

## 작동
 1. 'module-receiver' 를 여러개 띄워놓는다.
 2. ActiveMQ Web Console 접근하여, Queue / Topic 구성 결과를 슥 본다.  
 3. 'module-boot' 하나 띄워놓고, REST 로 메시지를 전송해본다.
 4. 'module-boot' 포함하여, 다수의 'module-receiver' 에서 Queue / Topic 성격에 맞게 메시지 수신 결과를 확인한다.    
    ```
    Sending an email message. (Queue)
    Received <Email{to=queue@example.com, body=Queue}>
    Sending an email message. (Queue)
    Sending an email message. (Queue)
    Received <Email{to=queue@example.com, body=Queue}>
    Sending an email message. (Topic)
    Received (Topic) <Email{to=topic@example.com, body=Topic}>
    ```

## 생각
`JmsListenerContainerFactory` 를 Queue / Topic 타입으로 각기 생성했는데 이 부분에 대해서 개선할 수 있는 부분을 고려 중이다.
