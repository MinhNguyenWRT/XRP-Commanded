package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.XRPDrivetrain;

public class Auton extends Command{
  private final XRPDrivetrain m_XRPDrivetrain;

  private AnalogInput m_leftSensor;
  private AnalogInput m_rightSensor;

  private DoubleSupplier m_lSensor;
  private DoubleSupplier m_rSensor;

  public Auton(AnalogInput leftSensor, AnalogInput rightSensor,XRPDrivetrain XRPDrivetrain) {
    m_leftSensor = leftSensor;
    m_rightSensor = rightSensor;
    m_lSensor = () -> m_leftSensor.getVoltage();
    m_rSensor = () -> m_rightSensor.getVoltage();
    m_XRPDrivetrain = XRPDrivetrain;
    addRequirements(XRPDrivetrain);
  }

    public void execute() {
      Commands.sequence(
        Commands.print("L " + m_lSensor.getAsDouble()),
        Commands.print("R " + m_rSensor.getAsDouble())
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