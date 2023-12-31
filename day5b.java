package com.shpp.p2p.cs.siskov.adventofcode;

/**
 * This task "Day 5: If You Give A Seed A Fertilizer" is from https://adventofcode.com/2023/day/5#part2
 * We need to calculate the total points of cards.
 * Created by Sergii Iskov, 2023. Version 2.0
 */
public class day5b {
    public static void main(String[] args) {
        // transform input data from string to array
        String[] seedsArray = seeds.split("\s");
        String[] seedToSoilArray = seedToSoil.split("\n");
        String[] soilToFertilizerArray = soilToFertilizer.split("\n");
        String[] fertilizerToWaterArray = fertilizerToWater.split("\n");
        String[] waterToLightArray = waterToLight.split("\n");
        String[] lightToTemperatureArray = lightToTemperature.split("\n");
        String[] temperatureToHumidityArray = temperatureToHumidity.split("\n");
        String[] humidityToLocationArray = humidityToLocation.split("\n");

        // transform string array to 2d digital array
        long[][] seedToSoilMap = create2DArr(seedToSoilArray);
        long[][] soilToFertilizerMap = create2DArr(soilToFertilizerArray);
        long[][] fertilizerToWaterMap = create2DArr(fertilizerToWaterArray);
        long[][] waterToLightMap = create2DArr(waterToLightArray);
        long[][] lightToTemperatureMap = create2DArr(lightToTemperatureArray);
        long[][] temperatureToHumidityMap = create2DArr(temperatureToHumidityArray);
        long[][] humidityToLocationMap = create2DArr(humidityToLocationArray);

        long minLocation = -1;
        for (int i = 0; i < seedsArray.length; i += 2) {
            int range = Integer.parseInt(seedsArray[i + 1]);
            long seed = Long.parseLong(seedsArray[i]) ;

            for (int j = 0; j < range; j++) {
                long soil = findValue(seed + j, seedToSoilMap);
                long fertilizer = findValue(soil, soilToFertilizerMap);
                long water = findValue(fertilizer, fertilizerToWaterMap);
                long light = findValue(water, waterToLightMap);
                long temperature = findValue(light, lightToTemperatureMap);
                long humidity = findValue(temperature, temperatureToHumidityMap);
                long location = findValue(humidity, humidityToLocationMap);
                minLocation = (minLocation == -1) ? location : Math.min(location, minLocation);
            }

        }
        System.out.println(minLocation);
    }

    private static long findValue(long key, long[][] mapColl) {
        for (int i = 0; i < mapColl.length; i++) {
            if (((key - mapColl[i][0]) >= 0) && ((key - mapColl[i][0]) < mapColl[i][2])) {
                return ((key - mapColl[i][0]) + mapColl[i][1]);
            }
        }
        return key;
    }

    private static long[][] create2DArr(String[] elemArray) {
        long[][] newArr = new long[elemArray.length][3];
        for (int i = 0; i < elemArray.length; i++) {
            String[] range = elemArray[i].split("\s");
            newArr[i][0] = Long.parseLong(range[1]);
            newArr[i][1] = Long.parseLong(range[0]);
            newArr[i][2] = Long.parseLong(range[2]);
        }
        return newArr;
    }

    private static String seeds = "950527520 85181200 546703948 123777711 63627802 279111951 1141059215 246466925 1655973293 98210926 3948361820 92804510 2424412143 247735408 4140139679 82572647 2009732824 325159757 3575518161 370114248";
    private static String seedToSoil =
            "3642212803 1631134559 163560083\n" +
                    "490926575 928751267 67070832\n" +
                    "557997407 23457277 146367872\n" +
                    "1526937660 2215630922 150973756\n" +
                    "3370882556 1217101081 21950620\n" +
                    "1998387949 1553503793 77630766\n" +
                    "1700281630 3586410917 298106319\n" +
                    "1677911416 1187175123 22370214\n" +
                    "1361013180 1890531530 165924480\n" +
                    "157249059 169825149 28413033\n" +
                    "1236300152 2104867413 110763509\n" +
                    "3048056947 3311996711 274414206\n" +
                    "1347063661 1173225604 13949519\n" +
                    "3322471153 2056456010 42709335\n" +
                    "3400388920 3884517236 61733835\n" +
                    "704365279 355487241 15789127\n" +
                    "3462122755 1794694642 95836888\n" +
                    "4043589752 1302126249 251377544\n" +
                    "3601338302 4254092795 40874501\n" +
                    "3557959643 4210714136 43378659\n" +
                    "3805772886 3946251071 237816866\n" +
                    "3365180488 2099165345 5702068\n" +
                    "185662092 19444885 4012392\n" +
                    "209119369 371276368 153333015\n" +
                    "2806369338 4184067937 26646199\n" +
                    "720154406 524609383 275667693\n" +
                    "189674484 0 19444885\n" +
                    "3392833176 1209545337 7555744\n" +
                    "362452384 800277076 128474191\n" +
                    "1173225604 1239051701 63074548\n" +
                    "2833015537 2366604678 215041410\n" +
                    "2076018715 2581646088 730350623\n" +
                    "0 198238182 157249059";
    private static String soilToFertilizer =
            "3460224655 4061418601 42469328\n" +
                    "2583088941 2211297482 32584821\n" +
                    "332145562 90342895 63482901\n" +
                    "2528755615 1387266751 32998710\n" +
                    "2197749180 696338617 193485827\n" +
                    "2391235007 2169459779 41837703\n" +
                    "395628463 1106056857 212736766\n" +
                    "158816023 1996130240 173329539\n" +
                    "608365229 553497263 142841354\n" +
                    "2945065740 425270652 128226611\n" +
                    "68473128 0 90342895\n" +
                    "2615673762 153825796 271444856\n" +
                    "2433072710 3107109424 95682905\n" +
                    "3073292351 976556879 129499978\n" +
                    "3969026580 3537847573 248317798\n" +
                    "751206583 889824444 86732435\n" +
                    "837939018 1420265461 575864779\n" +
                    "1413803797 2243882303 783945383\n" +
                    "4217344378 3460224655 77622918\n" +
                    "3502693983 4103887929 191079367\n" +
                    "0 1318793623 68473128\n" +
                    "3693773350 3786165371 275253230\n" +
                    "2887118618 3049162302 57947122\n" +
                    "2561754325 3027827686 21334616";
    private static String fertilizerToWater =
            "1751080383 1821072608 33265395\n" +
                    "4137558434 4169230929 125736367\n" +
                    "3296451041 3015767106 200702605\n" +
                    "0 1326187179 494885429\n" +
                    "3623687794 2963533004 52234102\n" +
                    "3192345181 2859427144 104105860\n" +
                    "1720274003 150099674 16362281\n" +
                    "1535290150 1141203326 184983853\n" +
                    "1736636284 166461955 14444099\n" +
                    "2888685656 3812924581 152666193\n" +
                    "3793268338 3216469711 344290096\n" +
                    "494885429 0 80107449\n" +
                    "2744325907 3668564832 144359749\n" +
                    "2708433812 3965590774 35892095\n" +
                    "3497153646 4042696781 126534148\n" +
                    "4263294801 4011024286 31672495\n" +
                    "1844603063 80107449 69992225\n" +
                    "3041351849 2708433812 150993332\n" +
                    "3675921896 3560759807 107805025\n" +
                    "574992878 180906054 960297272\n" +
                    "1784345778 1854338003 60257285\n" +
                    "3783726921 4001482869 9541417";
    private static String waterToLight =
            "3535151283 3877657516 42746103\n" +
                    "649917020 553881424 674909939\n" +
                    "3807807238 1821616588 484912477\n" +
                    "95679819 472295571 81585853\n" +
                    "1324826959 286073377 186222194\n" +
                    "4292719715 1819369007 2247581\n" +
                    "177265672 1324471182 186577971\n" +
                    "2102818048 3206912207 157155638\n" +
                    "2259973686 2823586602 100381277\n" +
                    "0 1228791363 95679819\n" +
                    "3577897386 3851861395 25796121\n" +
                    "363843643 0 286073377\n" +
                    "2530300196 3364067845 487793550\n" +
                    "3018093746 2306529065 90018685\n" +
                    "3603693507 4090853565 204113731\n" +
                    "2360354963 3920403619 169945233\n" +
                    "1819369007 4090348852 504713\n" +
                    "1819873720 2923967879 282944328\n" +
                    "3108112431 2396547750 427038852";
    private static String lightToTemperature =
            "4211717977 1537920618 83249319\n" +
                    "2812170666 2785100632 907832086\n" +
                    "3720002752 3692932718 462018744\n" +
                    "809029346 1621169937 408226713\n" +
                    "2495104775 2468034741 317065891\n" +
                    "1890424927 2029396650 438638091\n" +
                    "2329063018 740254029 124497721\n" +
                    "4182021496 4223726779 29696481\n" +
                    "1217256059 864751750 673168868\n" +
                    "2453560739 4253423260 41544036\n" +
                    "740254029 4154951462 68775317";
    private static String temperatureToHumidity =
            "247604558 3495276000 30921272\n" +
                    "1341115815 1344043806 205388222\n" +
                    "1546504037 3081217791 414058209\n" +
                    "1960562246 0 459661266\n" +
                    "0 959204089 247604558\n" +
                    "3388962113 1206808647 137235159\n" +
                    "278525830 1549432028 563047162\n" +
                    "841572992 459661266 499542823\n" +
                    "2420223512 2112479190 968738601";
    private static String humidityToLocation =
            "358497203 1012762605 163293355\n" +
                    "3035263355 2859367155 247612329\n" +
                    "1021885490 1293357218 103090913\n" +
                    "4143961841 3795114494 151005455\n" +
                    "3578373583 4227561425 8426352\n" +
                    "2859178122 2177370950 6068675\n" +
                    "0 1639932830 187421121\n" +
                    "521790558 232394351 43765724\n" +
                    "3838880131 4235987777 10124834\n" +
                    "1294200510 23652296 201098270\n" +
                    "2865246797 3380887726 170016558\n" +
                    "2177370950 4100409404 127152021\n" +
                    "3282875684 3954902589 51287689\n" +
                    "1124976403 1891601121 169224107\n" +
                    "3334163373 3550904284 244210210\n" +
                    "565556282 224750566 7643785\n" +
                    "3586799935 2183439625 194442871\n" +
                    "573200067 0 23652296\n" +
                    "3781242806 3946119949 8782640\n" +
                    "2716371460 3238081064 142806662\n" +
                    "2304522971 2377882496 116771158\n" +
                    "3790025446 4246112611 48854685\n" +
                    "1495298780 447236157 565526448\n" +
                    "596852363 1585957916 53974914\n" +
                    "840337062 1827353951 64247170\n" +
                    "187421121 276160075 171076082\n" +
                    "2622152334 4006190278 94219126\n" +
                    "2491050754 3106979484 131101580\n" +
                    "650827277 1396448131 189509785\n" +
                    "2421294129 2789610530 69756625\n" +
                    "3849004965 2494653654 294956876\n" +
                    "904584232 1176055960 117301258";
}

