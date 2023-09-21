package hello.springtx.order;

//잔고 부족 비즈니스 예회
public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(String message) {
        super(message);

    }
}
