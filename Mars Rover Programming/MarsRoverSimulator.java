import java.util.ArrayList;
import java.util.List;

// ENUM to represent directions
enum Direction {
    N, E, S, W;

    // Turns left based on current direction
    public Direction turnLeft() {
        return values()[(ordinal() + 3) % 4];
    }

    // Turns right based on current direction
    public Direction turnRight() {
        return values()[(ordinal() + 1) % 4];
    }
}

// Position class to handle coordinates
class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Move in the specified direction
    public Position move(Direction direction) {
        switch (direction) {
            case N: return new Position(x, y + 1);
            case S: return new Position(x, y - 1);
            case E: return new Position(x + 1, y);
            case W: return new Position(x - 1, y);
        }
        return this;
    }

    // Check equality of positions
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Position) {
            Position pos = (Position) obj;
            return x == pos.x && y == pos.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// Grid class: Composite pattern to represent the grid and obstacles
class Grid {
    private int width, height;
    private List<Position> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new ArrayList<>();
    }

    // Add obstacles to the grid
    public void addObstacle(Position obstacle) {
        obstacles.add(obstacle);
    }

    // Check if the position is within the grid and not an obstacle
    public boolean isValidPosition(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
               position.getY() >= 0 && position.getY() < height &&
               !obstacles.contains(position);
    }
}

// Command Interface: Command pattern for M, L, R
interface Command {
    void execute();
}

// Concrete command for moving the Rover
class MoveCommand implements Command {
    private Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.move();
    }
}

// Concrete command for turning left
class TurnLeftCommand implements Command {
    private Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnLeft();
    }
}

// Concrete command for turning right
class TurnRightCommand implements Command {
    private Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnRight();
    }
}

// Rover Class
class Rover {
    private Position position;
    private Direction direction;
    private Grid grid;

    public Rover(Grid grid, Position startPosition, Direction startDirection) {
        this.grid = grid;
        this.position = startPosition;
        this.direction = startDirection;
    }

    // Move forward in the current direction
    public void move() {
        Position newPosition = position.move(direction);
        if (grid.isValidPosition(newPosition)) {
            position = newPosition;
        } else {
            System.out.println("Obstacle detected or out of bounds at " + newPosition);
        }
    }

    // Turn the rover left
    public void turnLeft() {
        direction = direction.turnLeft();
    }

    // Turn the rover right
    public void turnRight() {
        direction = direction.turnRight();
    }

    // Get the current status report
    public String getStatus() {
        return "Rover is at " + position + " facing " + direction;
    }
}

// MarsRoverSimulator: Handles the simulation logic
public class MarsRoverSimulator {
    public static void main(String[] args) {
        // Create a 10x10 grid
        Grid grid = new Grid(10, 10);

        // Add obstacles
        grid.addObstacle(new Position(2, 2));
        grid.addObstacle(new Position(3, 5));

        // Initialize the rover at position (0, 0) facing North
        Rover rover = new Rover(grid, new Position(0, 0), Direction.N);

        // List of commands to execute
        List<Command> commands = new ArrayList<>();
        commands.add(new MoveCommand(rover));
        commands.add(new MoveCommand(rover));
        commands.add(new TurnRightCommand(rover));
        commands.add(new MoveCommand(rover));
        commands.add(new TurnLeftCommand(rover));
        commands.add(new MoveCommand(rover));

        // Execute commands
        for (Command command : commands) {
            command.execute();
        }

        // Print final status report
        System.out.println(rover.getStatus());
    }
}
