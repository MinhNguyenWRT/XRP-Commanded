package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.XRPDrivetrain;

public class Auton extends Command{
  private final XRPDrivetrain m_XRPDrivetrain;

  private final AnalogInput m_leftSensor = new AnalogInput(0);
  private final AnalogInput m_rightSensor = new AnalogInput(1);

  private final DoubleSupplier m_lSensorDou = () -> m_leftSensor.getVoltage();
  private final DoubleSupplier m_rSensorDou = () -> m_rightSensor.getVoltage();

  private final BooleanSupplier m_lSensorBoolS = () -> m_leftSensor.getVoltage() > 0.0;
  private final BooleanSupplier m_rSensorBoolS = () -> m_rightSensor.getVoltage() > 0.0;


  public Auton(XRPDrivetrain XRPDrivetrain) {
    m_XRPDrivetrain = XRPDrivetrain;
    addRequirements(XRPDrivetrain);
  }

    public void initialize() {
      System.out.println("Auton start");
      //Work in Process
      //Print the sensors' values
      Commands.repeatingSequence(
        Commands.print("" + m_lSensorDou),
        Commands.print("" + m_rSensorDou)
      ).schedule();
      //Auton going in a straight line
      Commands.sequence(
        Commands.race(
          Commands.run(() -> m_XRPDrivetrain.arcadeDrive(1, 0), m_XRPDrivetrain),
          Commands.waitSeconds(3)
        )
        ).schedule();

    }
}