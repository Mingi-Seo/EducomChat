EducomChat
==========

Final Term

TTD And Refactoring

===================

Refactoring 과정

- 처음의 소스 코드는 Client와 Server, 2개의 클래스로만 나뉘어져 있으며, 각각의 클래스들이 다양한 일을 처리하고 있습니다.
- Client Class에서는 사용자 인터페이스를 구성하여 화면에 뿌려주고, 인터페이스에 따라 발생하는 이벤트 처리를 해주고 있으며, 소켓을 생성하여 Client가 서버에 접속할 수 있도록 하고 있습니다.
- Server Class에서는 ServerThread를 생성하여 Client가 접속할 때마다 chatThread Arrray List에 담아두어 유지, 관리하고 있으며, 특정 Client가 다른 Client 들에게 메시지를 전송하면 서버에서는 이 메시지를 현재 접속하고 있는 모든 Client에게 Broadcasting 해주고 있습니다. 또한, Client 쓰레드를 내부 클래스로 정의하여 그 역할을 명시해주고 있습니다.
 
- 이와 같이 하나의 클래스에 너무 많은 책임인 인가되어 있고, 다양한 일을 처리해주는 로직을 갖고 있는 클래스들을 MVC 구조로 Refactoring 하게 되었습니다. 멀티 쓰레드 기반의 채팅 프로그램이 MVC 구조로 Refactoring 하기에 가장 좋은 예라고 생각하였고, MVC 구조가 잘 적용되어 구현이 이루어진다면 사용자 인터페이스로 부터 비즈니스 로직이 분리되어 서로 간의 영향 없이 쉽게 코드를 수정할 수 있을 것이라고 생각했습니다.

- Refactoring 과정에서 SOLID 원칙 중에서 SRP 원칙을 위반한 Client 클래스와 Server 클래스에서 각각의 역할과 책임을 분리하고, 우선적으로 데이터의 입출력을 담당하고 UI를 구성하여 화면에 뿌려주는 역할을 하는 View와 객체나 데이터의 흐름을 책임지는 Controller, Controller로 부터 전달받은 객체나 데이터를 비즈니스 로직에 따라 가공, 처리하는 Model로 나누어서 SRP 원칙에 위배되지 않도록 하였습니다. 그러나 아직 Model 부분은 구현이 안되어 있는 상황입니다.
- 그리고 SRP 원칙을 지키면서 MVC 구조를 갖추게 함으로써 OCP에 위배되지 않도록 하여 비즈니스 로직을 MVC 간의 영향 없이 쉽게 수정할 수 있도록 하였습니다.
- 또한, LIP에 위배되지 않기 위해서 필요 이상의 상속을 사용하지 않고서 구현을 하였습니다.
- 그리고 ISP에 위배되지 않으면서 Client에서 발생하는 이벤트를 처리하기 위해 ClientEventListener를 구현하여 사용하도록 하였고,
- 객체들 간의 Coupling을 낮추기 위해서 DI가 적용되어 DIP를 준수하고 있습니다.

이를 통해 MVS 구조와 SOLID 원칙을 준수하여 Refactoring을 하였습니다. 물론, 아직 완벽하게 구현되지 않았고, Refactoring이 덜 되어 있는 상황이기 때문에 MVC 구조나 SOLID에 대해서 부족한 점이 많이 있지만, 시작은 위와 같은 이유에 의해서 Refactoring을 진행하게 되었습니다.

그 결과, 아직 미흡한 부분은 많이 있으나, 처음에 Client Class와 Server Class에서 다양한 책임과 역할을 분리해내었고, MVC 구조를 적용하여 View와 Controller를 구현하였습니다. 그로 인해서 UI의 수정이 용이해졌고, Controller의 역할 또한 명확해졌습니다. 그 밖에도 코드의 가독성을 높이고, 로직을 단순하게 하기 위해 중복 코드를 최소화하였으며, IntelliJ의 Extract Method 기능을 통해 기계적으로 메서드를 추출해내었습니다. 또한, JUnit 테스트 코드와 IntelliJ의 디버깅 기능을 통해서 버그를 찾아내어 수정하고, 정상적으로 동작할 수 있게끔 Refactoring 하였습니다.


P.S.

- 아직 구현하지 못한 Model 부분을 구현하려고 하고 있습니다. 그리고 View와 Controller 부분도 계속 Refactoring하여 완벽한 MVC 구조를 갖출 수 있도록 할 예정이며, OOP의 SOLID 원칙을 잘 준수하여 Refactoring의 완성도를 높이려고 하고 있습니다.
- 마지막으로, 제가 윈도우 환경에서 작업을 하다보니 한글 Commit Log가 깨져버렸습니다. 이는 윈도우 환경에서는 GitHub 인코딩 값이 Default로 MS949로 설정되어 있기 때문에 발생한 현상인데, 이는 바로 UTF-8로 설정하여 수정하였습니다. 그러나 이미 깨져버린 한글 Commit Log는 어쩔 수가 없기에 이후에 다시 수정해서 Commit Log를 남기도록 하겠습니다.
