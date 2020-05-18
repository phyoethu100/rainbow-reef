package RainbowReef;

public class Map {

    public static boolean extraPop;
    public static int bigleg, level, lives, score;
    public static int[][] map;

    public Map() {
        map = new int[15][30];
        lives = 4;
        score = 0;
        extraPop = false;
        setLevelOne();
    }

   // Block 1 - red
   // Block 2 - light blue (2 -> 3)
   // Block 3 - blue
   // Block 4 - green
   // Block 5 - yellow (5 -> 4)
   // Block 6 - orange (6 -> 1)
   // Block 7 - purple (7 -> 2 -> 3)
   // Block Extra Life = 8
   // Block Extra Pop = 9
   // Block Solid = -1
   // BigLeg’s Upper Body = -2
   // BigLeg’s Lower Body = -4

    public void setLevelOne() {
        bigleg = 3;
        level = 1;

        // Blocks 1-7
        for (int i = 0; i < 8; i++) {
            map[i][2] = 7;
            map[i][3] = 4;
            map[i][4] = 2;
            map[i][5] = 6;
            map[i][6] = 1;
            map[i][7] = 5;
            map[i][8] = 3;
        }

        for (int i = 8; i < 15; i++) {
            map[i][2] = 7;
            map[i][3] = 5;
            map[i][4] = 1;
            map[i][5] = 6;
            map[i][6] = 2;
            map[i][7] = 4;
            map[i][8] = 3;
        }

        // Solid block
        for (int j = 0; j < 2; j++) {
            map[7][j] = -1;
        }

        // Extra life block
        map[7][3] = 7;
        map[1][3] = 8;
        map[13][3] = 8;
        map[7][4] = 8;

        // Extra pop block
        map[3][6] = 9;
        map[11][6] = 9;

        // Bigleg's upper and lower body
        map[3][0] = -2;
        map[3][1] = -4;
        map[7][6] = -2;
        map[7][7] = -4;
        map[11][0] = -2;
        map[11][1] = -4;

    }

    public void setLevelTwo() {
        map = new int[15][30];
        bigleg = 3;
        level = 2;

        // Red block
        for (int i = 3; i < 12; i++) {
            map[i][4] = 1;
            map[i][13] = 1;
        }

        for (int j = 4; j < 14; j++) {
            map[3][j] = 1;
            map[11][j] = 1;
        }

        // Light blue block
        for (int i = 4; i < 11; i++) {
            map[i][5] = 2;
            map[i][12] = 2;
        }

        for (int j = 5; j < 13; j++) {
            map[4][j] = 2;
            map[10][j] = 2;
        }

        // Green block
        for (int i = 5; i < 10; i++) {
            map[i][6] = 4;
            map[i][11] = 4;
        }

        for (int j = 6; j < 12; j++) {
            map[5][j] = 4;
            map[9][j] = 4;
        }

        // Yellow block
        for (int i = 6; i < 9; i++) {
            map[i][7] = 5;
            map[i][10] = 5;
        }

        for (int j = 7; j < 11; j++) {
            map[6][j] = 5;
            map[8][j] = 5;
        }

        // Blue block
        map[4][0] = 3;
        map[6][0] = 3;
        map[8][0] = 3;
        map[10][0] = 3;
        map[5][1] = 3;
        map[7][1] = 3;
        map[9][1] = 3;
        map[4][2] = 3;
        map[6][2] = 3;
        map[8][2] = 3;
        map[10][2] = 3;

        // Orange block
        map[4][1] = 6;
        map[6][1] = 6;
        map[8][1] = 6;
        map[10][1] = 6;
        map[5][2] = 6;
        map[7][2] = 6;
        map[9][2] = 6;

        // Purple block
        for (int i = 0; i < 4; i++) {
            map[i][2] = 7;
        }

        for (int i = 11; i < 15; i++) {
            map[i][2] = 7;
        }

        // Solid block
        for (int j = 0; j < 2; j++) {
            map[3][j] = -1;
            map[11][j] = -1;
        }
        map[7][10] = -1;
        map[0][13] = -1;
        map[14][13] = -1;

        // Bigleg
        for (int i = 7; i < 8; i++) {
            map[i][8] = -2;
            map[i][9] = -4;
        }
        map[1][0] = -2;
        map[1][1] = -4;
        map[13][0] = -2;
        map[1][13] = -4;

        // Extra life block
        map[7][0] = 8;
        map[4][8] = 8;
        map[10][8] = 8;

        // Extra pop block
        map[7][5] = 9;
        map[5][0] = 9;
        map[9][0] = 9;

    }

}
