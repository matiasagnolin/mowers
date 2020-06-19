package org.seatcode.Command;

import org.seatcode.domain.Position;

@FunctionalInterface
public interface ICommand {
      Position  execute(Position position);
}
