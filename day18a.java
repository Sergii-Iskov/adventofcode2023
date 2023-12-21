package com.shpp.p2p.cs.siskov.adventofcode;

import java.util.ArrayList;
/**
 * This task "Day 18: Lavaduct Lagoon" is from https://adventofcode.com/2023/day/18
 * We need to calculate how many cubic meters of lava could it hold.
 * Created by Sergii Iskov, 2023. Version 1.0
 */
public class day18a {
    public static void main(String[] args) {
        String[] dataArray = data.split("\n");
        String[][] dirArray = new String[dataArray.length][3];
        for (int i = 0; i < dataArray.length; i++) {
            dirArray[i] = dataArray[i].split(" ");
        }

        ArrayList<int[]> trenchArr = new ArrayList<>();
        int x = 0, y = 0, boundaryPoints = 0;

        for (int i = 0; i < dirArray.length; i++) {
            int[] digStep = dig(trenchArr, dirArray[i], x, y);
            x = digStep[0];
            y = digStep[1];
            boundaryPoints += digStep[2];
        }

        double poligonArea = calculatePoligonArea(trenchArr);
        int trenchArea = boundaryPoints + calculateInnerPoints(poligonArea, boundaryPoints);
        System.out.println(trenchArea);
    }

    private static int[] dig(ArrayList<int[]> trench, String[] strings, int x, int y) {
        int[] result = new int[3];
        String dir = strings[0];
        int length = Integer.parseInt(strings[1]);
        int curX = x, curY = y;
        int dx = (dir.equals("R")) ? 1 : (dir.equals("L")) ? -1 : 0;
        int dy = (dir.equals("D")) ? 1 : (dir.equals("U")) ? -1 : 0;
        for (int i = 0; i < length; i++) {
            curX = curX + dx;
            curY = curY + dy;
            trench.add(new int[]{curX, curY});
        }
        result[0] = curX;
        result[1] = curY;
        result[2] = length;

        return result;
    }

    private static double calculatePoligonArea(ArrayList<int[]> trenchArr) {
        // https://en.wikipedia.org/wiki/Shoelace_formula
        double area = 0;
        for (int i = 1; i < trenchArr.size(); i++) {
            area += (double) ((trenchArr.get(i)[1] + trenchArr.get(i - 1)[1]) * (trenchArr.get(i - 1)[0] - trenchArr.get(i)[0])) / 2;
        }
        return Math.abs(area);
    }

    private static int calculateInnerPoints(double poligonArea, int boundaryPoints) {
        // https://en.wikipedia.org/wiki/Pick%27s_theorem
        return (int) (poligonArea - boundaryPoints / 2 + 1);
    }

    // not using method!!!
    private static boolean isNotFrontier(boolean[][] trench, int y, int x) {
        boolean left = false, right = false, up = false, down = false;
        for (int i = 0; i < x; i++) {
            if (trench[y][i])                 left = true;
        }
        for (int i = x + 1; i < trench[y].length; i++) {
            if (trench[y][i])                 right = true;
        }
        for (int i = 0; i < y; i++) {
            if (trench[i][x])                 up = true;
        }
        for (int i = y + 1; i < trench.length; i++) {
            if (trench[i][x])                 down = true;
        }
        return left && right && up && down;
    }
    private static String data2 = "R 6 (#70c710)\n" +
            "D 5 (#0dc571)\n" +
            "L 2 (#5713f0)\n" +
            "D 2 (#d2c081)\n" +
            "R 2 (#59c680)\n" +
            "D 2 (#411b91)\n" +
            "L 5 (#8ceee2)\n" +
            "U 2 (#caa173)\n" +
            "L 1 (#1b58a2)\n" +
            "U 2 (#caa171)\n" +
            "R 2 (#7807d2)\n" +
            "U 3 (#a77fa3)\n" +
            "L 2 (#015232)\n" +
            "U 2 (#7a21e3)";
    private static String data = "R 9 (#066240)\n" +
            "U 6 (#113213)\n" +
            "R 9 (#052360)\n" +
            "U 8 (#51bd03)\n" +
            "R 6 (#11ea10)\n" +
            "U 3 (#36d791)\n" +
            "L 10 (#3e6430)\n" +
            "U 6 (#36d793)\n" +
            "R 10 (#2dff30)\n" +
            "U 6 (#4a82a3)\n" +
            "R 3 (#773e40)\n" +
            "U 4 (#37a293)\n" +
            "L 6 (#1c3820)\n" +
            "U 6 (#03ecf3)\n" +
            "R 6 (#492d80)\n" +
            "U 8 (#4ea353)\n" +
            "R 2 (#659f60)\n" +
            "U 6 (#1007c3)\n" +
            "R 11 (#00dfe0)\n" +
            "U 2 (#12f123)\n" +
            "R 4 (#1dcd40)\n" +
            "U 3 (#0b6501)\n" +
            "R 5 (#0d0600)\n" +
            "U 7 (#6dfa41)\n" +
            "R 8 (#2dd4e0)\n" +
            "U 3 (#59ae43)\n" +
            "L 10 (#32b370)\n" +
            "U 6 (#1fb103)\n" +
            "L 3 (#429540)\n" +
            "U 6 (#704553)\n" +
            "R 9 (#3ddb10)\n" +
            "U 4 (#310113)\n" +
            "R 5 (#5636c0)\n" +
            "U 7 (#4472d3)\n" +
            "R 6 (#154f80)\n" +
            "U 4 (#2b15b3)\n" +
            "R 4 (#3299d0)\n" +
            "U 9 (#6a8e43)\n" +
            "R 9 (#6747b0)\n" +
            "U 8 (#5438a3)\n" +
            "R 6 (#4cd070)\n" +
            "U 5 (#2f3d81)\n" +
            "R 5 (#308a30)\n" +
            "U 6 (#25e5e1)\n" +
            "L 5 (#4f51d0)\n" +
            "U 7 (#5296c1)\n" +
            "L 6 (#4f51d2)\n" +
            "U 3 (#104111)\n" +
            "L 3 (#3943a0)\n" +
            "D 8 (#306fc1)\n" +
            "L 6 (#5409f0)\n" +
            "D 6 (#310d31)\n" +
            "L 8 (#49ee10)\n" +
            "U 4 (#429651)\n" +
            "L 9 (#18e2e0)\n" +
            "U 8 (#11eae1)\n" +
            "L 3 (#07c650)\n" +
            "U 2 (#377411)\n" +
            "L 4 (#1b04d0)\n" +
            "U 5 (#2b6853)\n" +
            "R 6 (#1d5ad0)\n" +
            "U 8 (#199b63)\n" +
            "L 5 (#1d5ad2)\n" +
            "U 3 (#42db93)\n" +
            "R 5 (#369b10)\n" +
            "U 10 (#518623)\n" +
            "R 7 (#4d5a90)\n" +
            "D 9 (#53a603)\n" +
            "R 5 (#04b4d0)\n" +
            "D 12 (#786203)\n" +
            "R 4 (#25b480)\n" +
            "U 8 (#5438a1)\n" +
            "R 6 (#1a40b0)\n" +
            "U 8 (#1dfd43)\n" +
            "R 7 (#348d10)\n" +
            "U 7 (#161661)\n" +
            "L 3 (#2ee3f0)\n" +
            "U 8 (#3427b3)\n" +
            "L 7 (#7ae880)\n" +
            "U 2 (#2c5023)\n" +
            "L 7 (#4845e0)\n" +
            "U 3 (#54ef73)\n" +
            "L 5 (#1f58c0)\n" +
            "U 9 (#213bb3)\n" +
            "L 5 (#1f58c2)\n" +
            "U 7 (#5c3e13)\n" +
            "L 13 (#5e2a30)\n" +
            "U 3 (#0e3fe1)\n" +
            "L 5 (#1e3070)\n" +
            "U 7 (#7cb7e1)\n" +
            "L 2 (#1e3072)\n" +
            "U 8 (#477171)\n" +
            "L 3 (#4001e0)\n" +
            "U 3 (#593983)\n" +
            "R 3 (#58bb90)\n" +
            "U 6 (#3cedc1)\n" +
            "R 4 (#685640)\n" +
            "U 11 (#687361)\n" +
            "R 6 (#685642)\n" +
            "U 3 (#145031)\n" +
            "R 5 (#00f910)\n" +
            "D 9 (#661d01)\n" +
            "R 2 (#102b22)\n" +
            "D 5 (#6893e1)\n" +
            "R 7 (#222222)\n" +
            "U 10 (#51eae3)\n" +
            "R 3 (#3f3592)\n" +
            "U 6 (#5bb4d3)\n" +
            "R 7 (#3cef52)\n" +
            "D 13 (#3cf733)\n" +
            "R 2 (#5518e2)\n" +
            "D 2 (#133dd1)\n" +
            "R 3 (#373d22)\n" +
            "U 8 (#482241)\n" +
            "R 5 (#4df300)\n" +
            "U 7 (#0f6221)\n" +
            "R 7 (#70d660)\n" +
            "D 6 (#38d661)\n" +
            "R 7 (#70d662)\n" +
            "D 5 (#3e8e21)\n" +
            "R 4 (#4df302)\n" +
            "D 7 (#087031)\n" +
            "L 11 (#5749b2)\n" +
            "D 4 (#2852e1)\n" +
            "R 13 (#57e132)\n" +
            "D 5 (#0c9261)\n" +
            "R 12 (#210b12)\n" +
            "D 6 (#0f2571)\n" +
            "R 8 (#224c22)\n" +
            "D 10 (#68bfe1)\n" +
            "R 6 (#224c20)\n" +
            "D 7 (#16e0c1)\n" +
            "R 3 (#210b10)\n" +
            "D 3 (#442281)\n" +
            "L 4 (#42b9e0)\n" +
            "D 4 (#0ea281)\n" +
            "L 11 (#256db0)\n" +
            "D 3 (#0e8461)\n" +
            "R 6 (#6e2e90)\n" +
            "D 7 (#4661c1)\n" +
            "R 2 (#5df4a2)\n" +
            "U 7 (#4bd251)\n" +
            "R 7 (#1f3352)\n" +
            "D 6 (#3788c1)\n" +
            "R 3 (#34a2d0)\n" +
            "U 6 (#5704d3)\n" +
            "R 4 (#1685b0)\n" +
            "U 13 (#5704d1)\n" +
            "L 4 (#31ff70)\n" +
            "U 5 (#207f01)\n" +
            "R 4 (#39c580)\n" +
            "U 7 (#42cc01)\n" +
            "R 5 (#083cc0)\n" +
            "D 13 (#31a351)\n" +
            "R 7 (#58fe30)\n" +
            "D 2 (#47aa91)\n" +
            "R 13 (#381a60)\n" +
            "D 5 (#419be1)\n" +
            "R 5 (#3f2250)\n" +
            "D 11 (#400151)\n" +
            "R 3 (#4335d2)\n" +
            "D 4 (#281fb1)\n" +
            "R 8 (#495512)\n" +
            "D 5 (#392571)\n" +
            "R 12 (#6af5f2)\n" +
            "D 3 (#200eb1)\n" +
            "L 5 (#7a2130)\n" +
            "D 2 (#4c00e1)\n" +
            "L 12 (#3a29d0)\n" +
            "D 5 (#3c1ac1)\n" +
            "L 3 (#5f7b32)\n" +
            "D 3 (#0d8b11)\n" +
            "R 12 (#310fb0)\n" +
            "U 5 (#0a4fe1)\n" +
            "R 3 (#6bb360)\n" +
            "D 14 (#0a4fe3)\n" +
            "R 6 (#05edf0)\n" +
            "U 14 (#15aad1)\n" +
            "R 6 (#6372d0)\n" +
            "D 5 (#4f53e1)\n" +
            "R 7 (#556b50)\n" +
            "D 11 (#738af1)\n" +
            "L 5 (#5310c2)\n" +
            "D 4 (#4ac441)\n" +
            "L 10 (#2706a2)\n" +
            "D 7 (#199ac1)\n" +
            "L 7 (#6159e2)\n" +
            "D 11 (#645f03)\n" +
            "L 6 (#045322)\n" +
            "U 6 (#729c81)\n" +
            "L 2 (#1282f2)\n" +
            "U 8 (#694dc1)\n" +
            "L 6 (#0fa212)\n" +
            "U 4 (#69a5b1)\n" +
            "L 7 (#1e2202)\n" +
            "D 10 (#060351)\n" +
            "L 6 (#4bfdf2)\n" +
            "D 5 (#099b31)\n" +
            "R 6 (#441412)\n" +
            "D 10 (#4cb631)\n" +
            "L 10 (#5694a2)\n" +
            "U 9 (#7a14e1)\n" +
            "L 6 (#3f2f92)\n" +
            "U 4 (#4da571)\n" +
            "R 6 (#50b9a2)\n" +
            "U 10 (#2ed803)\n" +
            "L 4 (#134160)\n" +
            "U 7 (#2acaf3)\n" +
            "L 8 (#74afc0)\n" +
            "D 4 (#3d68c3)\n" +
            "L 5 (#3d0d92)\n" +
            "D 4 (#6eec93)\n" +
            "L 6 (#3bbb52)\n" +
            "D 4 (#6eec91)\n" +
            "L 6 (#0f2842)\n" +
            "D 9 (#1ec923)\n" +
            "L 5 (#3a0d22)\n" +
            "D 9 (#11e583)\n" +
            "L 11 (#1903f2)\n" +
            "D 6 (#3f7201)\n" +
            "L 5 (#250910)\n" +
            "D 14 (#1b2b51)\n" +
            "R 5 (#250912)\n" +
            "D 3 (#24b541)\n" +
            "R 8 (#11ca02)\n" +
            "D 4 (#462411)\n" +
            "R 12 (#4f59c2)\n" +
            "D 8 (#03e411)\n" +
            "R 5 (#11cfc2)\n" +
            "D 6 (#0cc131)\n" +
            "L 2 (#2436c2)\n" +
            "D 4 (#00b911)\n" +
            "L 3 (#361fd2)\n" +
            "D 3 (#20abc1)\n" +
            "L 12 (#1195a2)\n" +
            "D 3 (#592e11)\n" +
            "R 4 (#1195a0)\n" +
            "D 12 (#0d0841)\n" +
            "R 7 (#14be72)\n" +
            "D 2 (#106423)\n" +
            "R 6 (#02fe72)\n" +
            "D 12 (#18cee3)\n" +
            "R 6 (#279fb2)\n" +
            "D 5 (#62f843)\n" +
            "R 3 (#279fb0)\n" +
            "D 2 (#083113)\n" +
            "R 14 (#527782)\n" +
            "D 4 (#4d9f31)\n" +
            "R 3 (#586c02)\n" +
            "U 8 (#4fed31)\n" +
            "L 13 (#001182)\n" +
            "U 3 (#162e73)\n" +
            "R 13 (#484332)\n" +
            "U 8 (#340373)\n" +
            "R 4 (#0f63c2)\n" +
            "D 4 (#4deac3)\n" +
            "R 4 (#1363a2)\n" +
            "D 10 (#23ad51)\n" +
            "R 3 (#6dcbf2)\n" +
            "D 5 (#2b66b1)\n" +
            "R 5 (#6dcbf0)\n" +
            "D 3 (#4908a1)\n" +
            "R 9 (#543be2)\n" +
            "D 9 (#3a7201)\n" +
            "R 8 (#21b8a0)\n" +
            "D 6 (#2ca061)\n" +
            "R 3 (#4275f2)\n" +
            "D 8 (#3519c1)\n" +
            "R 9 (#4275f0)\n" +
            "U 3 (#341cc1)\n" +
            "L 5 (#46fd30)\n" +
            "U 12 (#0fa2b1)\n" +
            "R 5 (#1876a0)\n" +
            "U 8 (#36d8a1)\n" +
            "R 3 (#368fe0)\n" +
            "D 9 (#4540d3)\n" +
            "R 6 (#41bb60)\n" +
            "D 9 (#002493)\n" +
            "R 7 (#466b40)\n" +
            "D 5 (#002491)\n" +
            "R 8 (#321820)\n" +
            "D 12 (#2b3663)\n" +
            "R 4 (#4a7952)\n" +
            "D 3 (#168223)\n" +
            "R 12 (#2aa142)\n" +
            "D 8 (#168221)\n" +
            "R 4 (#452432)\n" +
            "D 5 (#4f9b13)\n" +
            "L 10 (#446e60)\n" +
            "D 2 (#1c3ff3)\n" +
            "L 4 (#3e9c00)\n" +
            "D 7 (#259141)\n" +
            "R 14 (#384450)\n" +
            "D 4 (#232231)\n" +
            "L 4 (#60c810)\n" +
            "D 11 (#6032d3)\n" +
            "R 3 (#36e870)\n" +
            "D 2 (#1df173)\n" +
            "R 11 (#0db120)\n" +
            "U 6 (#703cc1)\n" +
            "L 7 (#624fa0)\n" +
            "U 6 (#0de781)\n" +
            "R 11 (#3a00e0)\n" +
            "U 10 (#232233)\n" +
            "L 11 (#3d9750)\n" +
            "U 5 (#3c1151)\n" +
            "R 7 (#4ef9d0)\n" +
            "U 10 (#311861)\n" +
            "R 3 (#112300)\n" +
            "U 6 (#3285e1)\n" +
            "R 2 (#288f40)\n" +
            "U 11 (#26c051)\n" +
            "R 4 (#6896a0)\n" +
            "U 5 (#386b11)\n" +
            "R 5 (#631030)\n" +
            "D 8 (#4792c1)\n" +
            "R 6 (#21ea20)\n" +
            "D 7 (#3575d3)\n" +
            "R 9 (#3ceb50)\n" +
            "D 4 (#3575d1)\n" +
            "R 4 (#34a9d0)\n" +
            "U 4 (#5264a1)\n" +
            "R 5 (#1696a0)\n" +
            "U 3 (#23f791)\n" +
            "R 2 (#483170)\n" +
            "U 12 (#041b61)\n" +
            "R 5 (#22b0b2)\n" +
            "D 7 (#2a12d1)\n" +
            "R 8 (#5fc182)\n" +
            "D 5 (#2b7011)\n" +
            "L 8 (#266f62)\n" +
            "D 3 (#221851)\n" +
            "R 4 (#73c0d2)\n" +
            "D 4 (#3e8191)\n" +
            "R 3 (#3ee782)\n" +
            "D 6 (#750613)\n" +
            "R 9 (#1050e2)\n" +
            "D 10 (#16d7f3)\n" +
            "R 9 (#4d0872)\n" +
            "U 8 (#7cf443)\n" +
            "R 10 (#2af7b2)\n" +
            "U 4 (#0f2273)\n" +
            "R 4 (#35a752)\n" +
            "U 4 (#3fe841)\n" +
            "L 11 (#72af12)\n" +
            "U 4 (#4103a1)\n" +
            "L 3 (#38d812)\n" +
            "U 4 (#040db3)\n" +
            "R 6 (#2bd442)\n" +
            "U 4 (#7cde33)\n" +
            "R 11 (#515f22)\n" +
            "D 4 (#44b033)\n" +
            "R 11 (#37f982)\n" +
            "D 7 (#423663)\n" +
            "R 3 (#458522)\n" +
            "U 7 (#423661)\n" +
            "R 11 (#2c4af2)\n" +
            "D 3 (#0e59d1)\n" +
            "R 2 (#6447f0)\n" +
            "D 8 (#2e1c21)\n" +
            "L 3 (#014802)\n" +
            "D 5 (#091391)\n" +
            "L 4 (#48d9f2)\n" +
            "D 5 (#4a7a81)\n" +
            "L 9 (#5a55c2)\n" +
            "U 4 (#470471)\n" +
            "L 8 (#08cd30)\n" +
            "U 6 (#3045e3)\n" +
            "L 3 (#549d60)\n" +
            "D 13 (#3045e1)\n" +
            "R 7 (#28a720)\n" +
            "D 6 (#1e70d1)\n" +
            "R 2 (#1e6600)\n" +
            "D 11 (#478e71)\n" +
            "R 4 (#6447f2)\n" +
            "D 5 (#0ee621)\n" +
            "R 6 (#37b312)\n" +
            "U 10 (#6498f1)\n" +
            "R 3 (#3c0e82)\n" +
            "D 10 (#071ed1)\n" +
            "R 6 (#1f03e2)\n" +
            "U 5 (#30fbe1)\n" +
            "R 6 (#0d3ce2)\n" +
            "D 3 (#4d6c31)\n" +
            "R 8 (#00a172)\n" +
            "D 7 (#2a2c43)\n" +
            "L 6 (#412cb2)\n" +
            "D 10 (#2a2c41)\n" +
            "R 6 (#3b5242)\n" +
            "D 7 (#538001)\n" +
            "L 6 (#52a032)\n" +
            "D 7 (#17a8c1)\n" +
            "L 8 (#470dc2)\n" +
            "U 7 (#1b8e23)\n" +
            "R 5 (#106df2)\n" +
            "U 7 (#7a1663)\n" +
            "L 5 (#4ddff0)\n" +
            "U 8 (#42acd3)\n" +
            "L 5 (#56c4b2)\n" +
            "U 2 (#35cd03)\n" +
            "L 7 (#56c4b0)\n" +
            "D 11 (#171d63)\n" +
            "L 5 (#2a74b0)\n" +
            "D 4 (#44d171)\n" +
            "L 7 (#352330)\n" +
            "D 2 (#4ac5c1)\n" +
            "L 2 (#219960)\n" +
            "D 8 (#6578c3)\n" +
            "R 4 (#664b00)\n" +
            "D 7 (#5a3513)\n" +
            "R 10 (#516070)\n" +
            "D 7 (#714473)\n" +
            "L 12 (#027522)\n" +
            "D 6 (#4dbc73)\n" +
            "R 8 (#235982)\n" +
            "D 5 (#0ad691)\n" +
            "R 11 (#58eb52)\n" +
            "D 10 (#1ca7e1)\n" +
            "L 11 (#0c9642)\n" +
            "D 4 (#713361)\n" +
            "L 8 (#5a48e2)\n" +
            "D 3 (#212d23)\n" +
            "L 11 (#685082)\n" +
            "D 2 (#3e8d73)\n" +
            "L 10 (#173ae2)\n" +
            "D 6 (#37e2c3)\n" +
            "L 7 (#0482a2)\n" +
            "D 7 (#011483)\n" +
            "L 3 (#1d1592)\n" +
            "U 10 (#361713)\n" +
            "L 6 (#1979b2)\n" +
            "U 10 (#4d7cc3)\n" +
            "R 5 (#1979b0)\n" +
            "U 3 (#094f63)\n" +
            "R 10 (#3ee0b2)\n" +
            "U 2 (#088093)\n" +
            "R 4 (#461142)\n" +
            "U 6 (#665263)\n" +
            "R 3 (#225b52)\n" +
            "U 6 (#4ee523)\n" +
            "L 6 (#536352)\n" +
            "D 4 (#522ed3)\n" +
            "L 11 (#582102)\n" +
            "U 4 (#269db3)\n" +
            "L 5 (#179a12)\n" +
            "U 6 (#6a5173)\n" +
            "L 3 (#4815e2)\n" +
            "U 9 (#0d6263)\n" +
            "R 8 (#4815e0)\n" +
            "D 3 (#651133)\n" +
            "R 4 (#4a23d2)\n" +
            "D 5 (#56dc33)\n" +
            "R 10 (#67e540)\n" +
            "U 8 (#113f83)\n" +
            "R 3 (#4f0e60)\n" +
            "U 7 (#227963)\n" +
            "L 14 (#0b02b0)\n" +
            "U 6 (#142bb3)\n" +
            "L 8 (#61d352)\n" +
            "U 3 (#607433)\n" +
            "L 3 (#61d350)\n" +
            "U 9 (#11e823)\n" +
            "L 2 (#4ddf10)\n" +
            "U 4 (#0297a3)\n" +
            "L 5 (#28c510)\n" +
            "U 9 (#254d33)\n" +
            "L 6 (#667c70)\n" +
            "U 4 (#4cee63)\n" +
            "L 5 (#17be00)\n" +
            "U 6 (#2ab593)\n" +
            "L 5 (#6965c0)\n" +
            "U 10 (#3992f3)\n" +
            "L 8 (#71eee2)\n" +
            "U 3 (#549c33)\n" +
            "L 4 (#6229f2)\n" +
            "D 7 (#549c31)\n" +
            "L 3 (#138762)\n" +
            "D 9 (#137c03)\n" +
            "L 4 (#05c640)\n" +
            "D 12 (#5d7683)\n" +
            "R 6 (#766010)\n" +
            "D 4 (#2b8573)\n" +
            "R 6 (#5211b0)\n" +
            "D 11 (#107431)\n" +
            "L 4 (#4fa3c0)\n" +
            "D 3 (#0fa8c1)\n" +
            "L 8 (#0f09a0)\n" +
            "D 8 (#11c621)\n" +
            "L 2 (#0279d2)\n" +
            "D 7 (#0698f1)\n" +
            "L 13 (#206482)\n" +
            "D 3 (#702551)\n" +
            "L 4 (#206480)\n" +
            "D 4 (#2524a1)\n" +
            "L 7 (#0279d0)\n" +
            "D 7 (#11ad61)\n" +
            "R 5 (#0f09a2)\n" +
            "D 10 (#1c13d1)\n" +
            "L 5 (#797cc0)\n" +
            "D 4 (#574951)\n" +
            "L 9 (#1c8850)\n" +
            "U 8 (#16b4e3)\n" +
            "L 5 (#5f7230)\n" +
            "U 6 (#16b4e1)\n" +
            "R 5 (#1a8190)\n" +
            "U 7 (#38db03)\n" +
            "L 8 (#61f7f2)\n" +
            "D 8 (#2ffcd3)\n" +
            "L 6 (#3d02f0)\n" +
            "D 7 (#2f4c41)\n" +
            "L 3 (#759ae0)\n" +
            "U 8 (#2f4c43)\n" +
            "L 11 (#12f720)\n" +
            "U 6 (#6646c3)\n" +
            "L 5 (#0cdfd2)\n" +
            "U 8 (#2fd9a3)\n" +
            "L 6 (#5ce6b2)\n" +
            "D 9 (#2fd9a1)\n" +
            "L 6 (#5bce72)\n" +
            "D 13 (#4190e3)\n" +
            "L 5 (#61f7f0)\n" +
            "D 3 (#422103)\n" +
            "R 11 (#1ba0a0)\n" +
            "D 2 (#26add3)\n" +
            "R 6 (#737590)\n" +
            "D 6 (#47b4a3)\n" +
            "R 5 (#301260)\n" +
            "D 4 (#67ddc3)\n" +
            "L 5 (#1a6472)\n" +
            "D 5 (#3f39b1)\n" +
            "R 3 (#3f3c52)\n" +
            "D 4 (#4dc143)\n" +
            "R 10 (#4d4d02)\n" +
            "U 10 (#4dc141)\n" +
            "R 5 (#2de652)\n" +
            "D 10 (#23ffc1)\n" +
            "R 7 (#039f02)\n" +
            "D 6 (#633973)\n" +
            "L 3 (#0dc4e2)\n" +
            "D 3 (#4fb793)\n" +
            "L 8 (#500d22)\n" +
            "D 5 (#074831)\n" +
            "L 6 (#364be2)\n" +
            "D 7 (#798241)\n" +
            "L 8 (#1ecbb2)\n" +
            "D 6 (#106d21)\n" +
            "L 6 (#19d752)\n" +
            "D 8 (#0262b3)\n" +
            "L 7 (#37dbd2)\n" +
            "D 6 (#49dd93)\n" +
            "L 7 (#37dbd0)\n" +
            "D 3 (#44f753)\n" +
            "L 10 (#075702)\n" +
            "U 5 (#383493)\n" +
            "L 7 (#2804c2)\n" +
            "U 4 (#2afdb3)\n" +
            "L 7 (#7659a2)\n" +
            "U 7 (#304e33)\n" +
            "L 3 (#25a752)\n" +
            "D 10 (#092863)\n" +
            "L 6 (#5a6172)\n" +
            "D 7 (#7440f3)\n" +
            "L 4 (#550252)\n" +
            "U 8 (#69d9e3)\n" +
            "L 2 (#5a7f42)\n" +
            "U 9 (#222963)\n" +
            "L 5 (#0f8972)\n" +
            "U 6 (#649783)\n" +
            "R 5 (#0f8970)\n" +
            "U 5 (#605383)\n" +
            "R 7 (#507c82)\n" +
            "D 5 (#032731)\n" +
            "R 7 (#51fae2)\n" +
            "U 8 (#3c4c41)\n" +
            "R 3 (#06b482)\n" +
            "U 6 (#5f6901)\n" +
            "L 10 (#06b480)\n" +
            "U 8 (#0b6551)\n" +
            "L 12 (#51fae0)\n" +
            "U 6 (#005df1)\n" +
            "L 5 (#0fd702)\n" +
            "U 4 (#116861)\n" +
            "L 6 (#608fe2)\n" +
            "U 9 (#350641)\n" +
            "L 4 (#3235b2)\n" +
            "U 7 (#2e00c1)\n" +
            "L 8 (#1b4652)\n" +
            "U 9 (#077cf1)\n" +
            "L 2 (#551f30)\n" +
            "U 9 (#4c1451)\n" +
            "L 11 (#73ccd0)\n" +
            "U 5 (#2ceaf1)\n" +
            "L 4 (#48be22)\n" +
            "U 14 (#4231b1)\n" +
            "L 2 (#4cd372)\n" +
            "U 3 (#4231b3)\n" +
            "R 6 (#1bd302)\n" +
            "U 12 (#23f4d1)\n" +
            "L 6 (#0699b0)\n" +
            "U 13 (#273fe1)\n" +
            "L 2 (#2d8310)\n" +
            "U 6 (#1c0d21)\n" +
            "L 11 (#642ca0)\n" +
            "U 6 (#1c0d23)\n" +
            "L 3 (#191b30)\n" +
            "U 11 (#2e6931)\n" +
            "L 3 (#299822)\n" +
            "U 4 (#3c6a61)\n" +
            "L 7 (#0dc482)\n" +
            "U 13 (#5c6871)\n" +
            "L 6 (#3e6222)\n" +
            "U 7 (#41a2e3)\n" +
            "L 8 (#4838b2)\n" +
            "D 5 (#572ff3)\n" +
            "L 5 (#0af492)\n" +
            "D 12 (#107a51)\n" +
            "L 4 (#6ad812)\n" +
            "D 3 (#05f313)\n" +
            "L 4 (#383772)\n" +
            "U 8 (#600b13)\n" +
            "L 9 (#383770)\n" +
            "U 11 (#5bf553)\n" +
            "L 5 (#19f2c2)\n" +
            "D 11 (#545c63)\n" +
            "L 7 (#637f42)\n" +
            "U 8 (#6f60d3)\n" +
            "L 12 (#59b262)\n" +
            "U 8 (#329013)";

}
