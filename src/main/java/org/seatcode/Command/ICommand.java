package org.seatcode.Command;

import org.seatcode.domain.Position;

@FunctionalInterface
public interface ICommand {
      void  execute(Position position);
}
