package hu.nye.progtech.battleship.model;


    public enum ShipType {
        AIRCRAFT_CARRIER(5, "Aircraft Carrier"),
        BATTLESHIP(4, "Battleship"),
        SUBMARINE(3, "Submarine"),
        CRUISER(3, "Cruiser"),
        DESTROYER(2, "Destroyer");

        private final int length;
        private final String name;

        ShipType(final int length, final String name) {
            this.length = length;
            this.name = name;
        }

        public int length() {
            return length;
        }

        @Override
        public String toString() {
            return name;
        }
    }

