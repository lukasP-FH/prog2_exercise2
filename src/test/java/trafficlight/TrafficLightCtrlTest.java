package trafficlight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TrafficLightCtrlTest {

    TrafficLightCtrl ctrl = null;

    @BeforeEach
    public void setEverything(){
        ctrl = TrafficLightCtrl.getInstance();
        ctrl.reset();
    }

    @Test
    @DisplayName("Test for Singleton")
    public void testSingleton(){
        TrafficLightCtrl ctrl2 = TrafficLightCtrl.getInstance();
        assertSame(ctrl2, ctrl, "not the same oh oh!");
    }

    @Test
    @DisplayName("Test for init State")
    public void testInitState(){
        assertSame(ctrl.getCurrentState(), ctrl.getGreenState(), "Wrong Init State!");
    }

    @Test
    @DisplayName("Test for second State")
    public void testSecondState(){
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(), ctrl.getYellowState(), "Wrong Second State!");
    }

    @Test
    @DisplayName("Test for third State")
    public void testThirdState(){
        ctrl.nextState();
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(), ctrl.getRedState(), "Wrong Third State!");
    }

    @Test
    @DisplayName("Test for fourth State")
    public void testFourthState(){
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(), ctrl.getYellowState(), "Wrong Fourth State!");
    }

    @Test
    @DisplayName("Test for fifth State")
    public void testFifthState(){
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        ctrl.nextState();
        assertSame(ctrl.getCurrentState(), ctrl.getGreenState(), "Wrong Fifth State!");
    }

}
