package edu.nyu.cs;

import java.util.Arrays;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {

    private int street = 10;
    private int avenue = 5;
    private String orientation = "south";
    private int gas = 100;


    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public void setAve(int ave) {
        this.avenue = ave;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.orientation;        
    }

    public int getStreet() {
        return this.street;
    }

    public int getAve() {
        return this.avenue;
    }

    /**
     * Handles the command,`how we doin'?`.
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
        return this. gas; 
    }

    /**
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        System.out.printf("\t The gas tank is currently %d%% full. \n", this.getGasLevel());
    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        this.setGas(this.getGasLevel() + (100 - this.getGasLevel()));
        this.printGasLevel();
    }

        /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
        this.setStreet(location[0]);
        this.setAve(location[1]);
    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        int[] location = {this.getStreet(), this.getAve()};
        return location;
    }

    public void adChecks() {
        if (this.getStreet() == 79 && this.getAve() == 8) {
            System.out.println("Welcome to the American Museum of Natural History!");
        } else if (this.getStreet() == 74 && this.getAve() == 1) {
            System.out.println("Welcome to the Memorial Sloan Kettering!");
        } else if (this.getStreet() == 56 && this.getAve() == 3) { 
            System.out.println("Welcome to Tina's Cuban Cuisine restaurant!");
        } else if (this.getStreet() == 12 && this.getAve() == 4) {
            System.out.println("Welcome to The Strand book shop!");
        } else {

        }
    }


    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing South.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        if (this.getStreet() % 10 == 1 && this.getAve() % 10 != 1 && this.getAve() % 10 != 2 && this.getAve() % 10 != 3) {
            System.out.printf("Now at %dst St. and %dth Ave, facing %s. \n", this.getStreet(), this.getAve(), this.getOrientation());
        } else if (this.getStreet() % 10 == 2 && this.getAve() % 10 != 1 && this.getAve() % 10 != 2 && this.getAve() % 10 != 3) {
            System.out.printf("Now at %dnd St. and %dth Ave, facing %s. \n", this.getStreet(), this.getAve(), this.getOrientation());
        } else if (this.getStreet() % 10 == 3 && this.getAve() % 10 != 1 && this.getAve() % 10 != 2 && this.getAve() % 10 != 3) {
            System.out.printf("Now at %drd St. and %dth Ave, facing %s. \n", this.getStreet(), this.getAve(), this.getOrientation());
        } else if (this.getAve() % 10 == 1) {
            System.out.printf("Now at %dth St. and %dst Ave, facing %s. \n", this.getStreet(), this.getAve(), this.getOrientation());
        } else if (this.getAve() % 10 == 2) {
            System.out.printf("Now at %dth St. and %dnd Ave, facing %s. \n", this.getStreet(), this.getAve(), this.getOrientation());
        } else if (this.getAve() % 10 == 3) {
            System.out.printf("Now at %dth St. and %drd Ave, facing %s. \n", this.getStreet(), this.getAve(), this.getOrientation());
        } else {
            System.out.printf("Now at %dth St. and %dth Ave, facing %s. \n", this.getStreet(), this.getAve(), this.getOrientation());
        }
    }

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        if (this.getGasLevel() < 5) {
            System.out.println("Out of gas. Please refill the tank.");
            return;
        }

        if (this.getOrientation().equals("north")) {
            this.setOrientation("west");
            if (this.getAve() == 10) {
                return;
            } else {
                this.setAve(this.getAve() + 1);
            }
        } else if (this.getOrientation().equals("south")) {
            this.setOrientation("east");
            if (this.getAve() == 1) {
                return;
            } else {
                this.setAve(this.getAve() - 1);
            }
        } else if (this.getOrientation().equals("east")) {
            this.setOrientation("north");
            if (this.getStreet() == 200) {
            } else {
                this.setStreet(this.getStreet() + 1);
            }
        } else if (this.getOrientation().equals("west")) {
            this.setOrientation("south");
            if (this.getStreet() == 1) {
            } else {
                this.setStreet(this.getStreet() - 1);
            }
        }

        this.setGas(this.getGasLevel() - 5);
        this.adChecks();
        return;
        
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        if (this.getGasLevel() < 5) {
            System.out.println("Out of gas. Please refill the tank.");
            return;
        }

        if (this.getOrientation().equals("north")) {
            this.setOrientation("east");
            if (this.getAve() == 1) {
                return;
            } else {
                this.setAve(this.getAve() - 1);
            }
        } else if (this.getOrientation().equals("south")) {
            this.setOrientation("west");
            if (this.getAve() == 10) {
                return;
            } else {
                this.setAve(this.getAve() + 1);
            }
        } else if (this.getOrientation().equals("east")) {
            this.setOrientation("south");
            if (this.getStreet() == 1) {
            } else {
                this.setStreet(this.getStreet() - 1);
            }
        } else if (this.getOrientation().equals("west")) {
            this.setOrientation("north");
            if (this.getStreet() == 200) {
            } else {
                this.setStreet(this.getStreet() + 1);
            }
        }

        this.setGas(this.getGasLevel() - 5);
        this.adChecks();
        return;
        
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        if (this.getGasLevel() < 5) {
            System.out.println("Out of gas. Please refill the tank.");
            return;
        }

        if (this.getOrientation().equals("north")) {
            if (this.getStreet() == 200) {
                return;
            } else {
                this.setStreet(this.getStreet() + 1);
            }
        } else if (this.getOrientation().equals("south")) {
            if (this.getStreet() == 1) {
                return;
            } else {
                this.setStreet(this.getStreet() - 1);
            }
        } else if (this.getOrientation().equals("east")) {
            if (this.getAve() == 1) {
            } else {
                this.setAve(this.getAve() - 1);
            }
        } else if (this.getOrientation().equals("west")) {
            if (this.getAve() == 10) {
            } else {
                this.setAve(this.getAve() + 1);
            }
        }

        this.setGas(this.getGasLevel() - 5);
        this.adChecks();
        return;
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        if (this.getGasLevel() < 5) {
            System.out.println("Out of gas. Please refill the tank.");
            return;
        }

        if (this.getOrientation().equals("north")) {
            if (this.getStreet() == 1) {
                return;
            } else {
                this.setStreet(this.getStreet() - 1);
            }
        } else if (this.getOrientation().equals("south")) {
            if (this.getStreet() == 200) {
                return;
            } else {
                this.setStreet(this.getStreet() + 1);
            }
        } else if (this.getOrientation().equals("east")) {
            if (this.getAve() == 10) {
            } else {
                this.setAve(this.getAve() + 1);
            }
        } else if (this.getOrientation().equals("west")) {
            if (this.getAve() == 1) {
            } else {
                this.setAve(this.getAve() - 1);
            }
        }

        this.setGas(this.getGasLevel() - 5);
        this.adChecks();
        return;
    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        
    }

    public void adjustAve() {  
        if (this.getGasLevel() == 0) {
            this.fillGas();
        }

        int aveCheck = 8;
        int direction = this.getAve() - aveCheck;

        if ((direction > 0 && this.getOrientation().equals("north")) || (direction < 0 && this.getOrientation().equals("south"))) {
            this.goRight();
        } else {
            this.goLeft();
        }
        
        if (this.getGasLevel() == 0) {
            this.fillGas();
        }

        this.printLocation();
        while (this.getAve() != aveCheck) {
            if (this.getGasLevel() == 0) {
                this.fillGas();
            }
            this.goStraight();
            this.printLocation();
        } 
    }

    public void autoGas() {
        if (this.getGasLevel() == 0) {
            this.fillGas();
        }
    }

    public void adjustStreet() {
        this.autoGas();

        int streetCheck = 15;
        int direction = this.getStreet() - streetCheck;
        String orientation = this.getOrientation();

        if ((direction > 0 && orientation.equals("west")) || (direction < 0 && orientation.equals("east"))) {
            this.goLeft();
        } else {
            this.goRight();
        }

        this.autoGas();

        this.printLocation();
        while (this.getStreet() != streetCheck) {
            this.autoGas();
            this.goStraight();
            this.printLocation();
        }      
    }

    public void generalAdjustments() {
        this.autoGas();
      
        int streetCheck = 15;
        int aveCheck = 8;
        
        if (this.getOrientation().equals("north") || this.getOrientation().equals("south")) {
            if (this.getStreet() < streetCheck) {
                while (this.getStreet() < streetCheck) {
                    this.autoGas();
                    if (this.getOrientation().equals("north")) {
                        this.goStraight();
                    } else {
                        this.goBackwards();
                    }
                    this.printLocation();
                }
            } else {
                while (this.getStreet() > streetCheck) {
                    this.autoGas();
                    if (this.getOrientation().equals("north")) {
                        this.goBackwards();
                    } else {
                        this.goStraight();
                    }
                    this.printLocation();
                }
            }
        } else {
            if (this.getAve() < aveCheck) {
                while (this.getAve() < aveCheck) {
                    this.autoGas();
                    if (this.getOrientation().equals("east")) {
                        this.goBackwards();
                    } else {
                        this.goStraight();
                    }
                    this.printLocation();
                }
            } else {
                while (this.getAve() > aveCheck) {
                    this.autoGas();
                    if (this.getOrientation().equals("east")) {
                        this.goStraight();
                    } else {
                        this.goBackwards();
                    }
                    this.printLocation();
                }
            }
        }
    }
    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        this.generalAdjustments();
        if (this.getAve() != 8) {
            this.adjustAve();
        } else if (this.getStreet() != 15) {
            this.adjustStreet();
        }
        return;
    }

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        String helpCommand = "The \"go left\" command will make the moped turn left and go one space in that direction.\n" +
                            "The \"go right\" command will make the moped turn right and go one space in that direction.\n" + 
                            "The \"straight on\" command will make the moped go one space in its current direction.\n" +
                            "The \"go to Xian's\" command will make the moped automatically go to Xian Famous Foods.\n" +
                            "The \"back up\" command will make the moped go back one space relative the direction its facing.\n" +
                            "The \"fill it up\" command will make the moped fill up on gas.\n" +
                            "The \"how we doin'?\" command will make tell you how much gas is left in the moped.\n" +
                            "The \"park\" command will make stop the simulation.\n";
        return helpCommand;       
    }

}
