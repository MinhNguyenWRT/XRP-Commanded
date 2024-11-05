package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.XRPDrivetrain;

public class Auton extends Command{
  private final XRPDrivetrain m_XRPDrivetrain;

  private AnalogInput m_leftSensor = new AnalogInput(0);
  private AnalogInput m_rightSensor = new AnalogInput(1);
  private AnalogInput m_utralSonic = new AnalogInput(2);

  private DoubleSupplier m_lSensorDou = () -> m_leftSensor.getVoltage();
  private DoubleSupplier m_rSensorDou = () -> m_rightSensor.getVoltage();

  private BooleanSupplier m_lSensorBoolS = () -> m_leftSensor.getVoltage() > 1.0;
  private BooleanSupplier m_rSensorBoolS = () -> m_rightSensor.getVoltage() > 1.0;


  public Auton(XRPDrivetrain XRPDrivetrain) {
    m_XRPDrivetrain = XRPDrivetrain;
    addRequirements(XRPDrivetrain);
  }

    public void initialize() {
      System.out.println("Auton start");
      //Work in Process
      //Print the sensors' values
      Commands.repeatingSequence(
        Commands.print("\n L " + m_lSensorDou.getAsDouble()),
        Commands.print("R " + m_rightSensor.getValue()),
        Commands.print("Ultra Sonic: " + m_utralSonic.getVoltage()),
        Commands.waitSeconds(1)
      ).schedule();
      //Auton going in a straight line
      /*Commands.sequence(
        Commands.race(
          Commands.run(() -> m_XRPDrivetrain.arcadeDrive(0, 0), m_XRPDrivetrain),
          Commands.waitSeconds(0)
        )
        ).schedule();/* */

    }
}