import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MouseClass {

	public static void main(String[] args) throws Exception {

		Robot robot = new Robot();

		MoveToPage(robot);
		
		while(true){

			Auto(robot, TaskType.CONNECT,10);	

			MoveAndLeftClickTwice(robot, 370, 145, 500);
			robot.delay(3000);
			MoveAndLeftClickTwice(robot, 370*3, 190, 500);
			robot.delay(3000);
			
		}

		
	}

	
	private static void loginToLinkedIn(Robot robot){
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
	}
	
	private static void pressBtns(){
		
	}
	
	
	public static void MoveToPage(Robot robot) {
		MoveAndLeftClickOnece(robot, 300, 1050, 1000);
		MoveAndLeftClickOnece(robot, 300, 950, 1000);
	}

	private static void Auto(Robot robot, TaskType choice,int total) {
		if (choice.equals(TaskType.ENDORSE)) {
			AutoEndorse(robot, total);
			//refreshEndrose(robot, total);

		} else {
			AutoAddConnectionsInMultiPages(robot, total, 4000, false);
		}

	}

	public static void refreshEndrose(Robot robot, int total) {
		int max=(int)total/8;
		while(max>0){
			AutoEndorse(robot, 8);
			robot.keyPress(KeyEvent.VK_F5);
			robot.keyRelease(KeyEvent.VK_F5);
			robot.delay(4000);
			MoveAndNoClick(robot, 360, 390, 3500);
			MoveAndLeftClickOnece(robot, 440, 420, 2000);
			robot.delay(4000);
			MoveAndNoClick(robot, 360, 390, 3500);
			max--;
		}
	}

	private static void AutoAddConnectionsInMultiPages(Robot robot,
			int pageNum, int delayTime, boolean isZhu) {

		for (int page = 0; page < pageNum; page++) {
			AutoAddConnectionsInOnePage(robot, isZhu);
			if(isZhu){
				robot.keyPress(KeyEvent.VK_F5);
				robot.keyRelease(KeyEvent.VK_F5);
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);
				robot.delay(delayTime);
			}else{
				robot.delay(delayTime+1500);
				
			}
			
		
		}
	}

	private static void AutoAddConnectionsInOnePage(Robot robot, boolean isZhu) {

		if (isZhu) {
			int startX = 330;
			int startY = 350;
			for (int j = 0; j < 5; j++) {
				for (int i = 0; i < 1; i++) {
					MoveAndLeftClickTwice(robot, startX, startY, 1000);
					MoveAndLeftClickTwice(robot, startX + 450, startY, 1000);
				}
				startY += 150;
			}
		} else {
			int startX = 430;
			int startY = 550;
			for (int j = 0; j < 2; j++) {
				MoveAndLeftClickTwice(robot, startX, startY, 500);
				MoveAndLeftClickTwice(robot, startX + 200, startY, 500);
				MoveAndLeftClickTwice(robot, startX + 400, startY, 500);
				MoveAndLeftClickTwice(robot, startX + 600, startY, 500);
				startY += 340;
			}
		}

	}

	private static void MoveAndLeftClickTwice(Robot robot, int startX,
			int startY, int delayTime) {
		robot.mouseMove(startX, startY);
		robot.delay(delayTime);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	private static void MoveAndLeftClickOnece(Robot robot, int startX,
			int startY, int delayTime) {
		robot.mouseMove(startX, startY);
		robot.delay(delayTime);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	private static void MoveAndNoClick(Robot robot, int startX, int startY,
			int delayTime) {
		robot.mouseMove(startX, startY);
		robot.delay(delayTime);
	}

	private static void AutoEndorse(Robot robot, int times) {

		int n = 8;
		for (int i = 0; i < times; i++) {
			MoveAndLeftClickTwice(robot, 360, 390, 500);
			MoveAndLeftClickTwice(robot, 720, 390, 500);
			MoveAndLeftClickTwice(robot, 720, 550, 500);
			MoveAndLeftClickTwice(robot, 360, 550, 500);
			n--;
			if (n <= 0) {
				n = 8;
				MoveAndLeftClickTwice(robot, 360, 600, 3000);
				MoveAndNoClick(robot, 360, 390, 3500);
			}
		}
	}
	
	private enum TaskType {ENDORSE,CONNECT};

}