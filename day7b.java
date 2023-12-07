package com.shpp.p2p.cs.siskov.adventofcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This task "Day 5: Camel Cards" is from https://adventofcode.com/2023/day/7
 * We need to calculate total winnings of multiplying each hand's bid with its rank.
 * J cards are jokers!!!
 * Created by Sergii Iskov, 2023. Version 2.0
 */
public class day7b {
    public static void main(String[] args) {
        /**
         * Class for Array sorting in order "J23456789TQKA"
         */
        class SortByChar implements Comparator<String[]> {
            public int compare(String[] a, String[] b) {
                String s = "J23456789TQKA";
                for (int i = 0; i < a[0].length(); i++) {
                    if (s.indexOf(a[0].charAt(i)) < s.indexOf(b[0].charAt(i))) return -1;
                    else if (s.indexOf(a[0].charAt(i)) > s.indexOf(b[0].charAt(i))) return 1;
                }
                return 0;
            }
        }

        String[] dataArr = data.split("\n");
        // create and fill ArrayList for different type of hand
        ArrayList<String[]> five = new ArrayList<>();
        ArrayList<String[]> four = new ArrayList<>();
        ArrayList<String[]> fullHouse = new ArrayList<>();
        ArrayList<String[]> three = new ArrayList<>();
        ArrayList<String[]> twoPair = new ArrayList<>();
        ArrayList<String[]> onePair = new ArrayList<>();
        ArrayList<String[]> noOrder = new ArrayList<>();

        for (int i = 0; i < dataArr.length; i++) {
            String[] hand = dataArr[i].split("\s");
            if (check(hand[0], 5, 0)) {
                five.add(hand);
            } else if (check(hand[0], 4, 0)) {
                four.add(hand);
            } else if (check(hand[0], 3, 2)) {
                fullHouse.add(hand);
            } else if (check(hand[0], 3, 0)) {
                three.add(hand);
            } else if (check(hand[0], 2, 2)) {
                twoPair.add(hand);
            } else if (check(hand[0], 2, 0)) {
                onePair.add(hand);
            } else {
                noOrder.add(hand);
            }
        }

        // transform ArrayList to Array
        String[][] fiveArr = transformArrayList(five);
        String[][] fourArr = transformArrayList(four);
        String[][] fullHouseArr = transformArrayList(fullHouse);
        String[][] threeArr = transformArrayList(three);
        String[][] twoPairArr = transformArrayList(twoPair);
        String[][] onePairArr = transformArrayList(onePair);
        String[][] noOrderArr = transformArrayList(noOrder);

        // sort Arrays by hand strength
        Arrays.sort(fiveArr, new SortByChar());
        Arrays.sort(fourArr, new SortByChar());
        Arrays.sort(fullHouseArr, new SortByChar());
        Arrays.sort(threeArr, new SortByChar());
        Arrays.sort(twoPairArr, new SortByChar());
        Arrays.sort(onePairArr, new SortByChar());
        Arrays.sort(noOrderArr, new SortByChar());

        // replace all hands to common Array
        String[][] scored = new String[dataArr.length][2];
        int count = 0;
        for (int i = count; i < noOrderArr.length; i++) {
            scored[i][0] = noOrderArr[i][0];
            scored[i][1] = noOrderArr[i][1];
        }

        count += noOrderArr.length;
        for (int i = 0; i < onePairArr.length; i++) {
            scored[i + count][0] = onePairArr[i][0];
            scored[i + count][1] = onePairArr[i][1];
        }

        count += onePairArr.length;
        for (int i = 0; i < twoPairArr.length; i++) {
            scored[i + count][0] = twoPairArr[i][0];
            scored[i + count][1] = twoPairArr[i][1];
        }

        count += twoPairArr.length;
        for (int i = 0; i < threeArr.length; i++) {
            scored[i + count][0] = threeArr[i][0];
            scored[i + count][1] = threeArr[i][1];
        }

        count += threeArr.length;
        for (int i = 0; i < fullHouseArr.length; i++) {
            scored[i + count][0] = fullHouseArr[i][0];
            scored[i + count][1] = fullHouseArr[i][1];
        }

        count += fullHouseArr.length;
        for (int i = 0; i < fourArr.length; i++) {
            scored[i + count][0] = fourArr[i][0];
            scored[i + count][1] = fourArr[i][1];
        }

        count += fourArr.length;
        for (int i = 0; i < fiveArr.length; i++) {
            scored[i + count][0] = fiveArr[i][0];
            scored[i + count][1] = fiveArr[i][1];
        }
        long res = 0;
        for (int i = 0; i < scored.length; i++) {
            System.out.println((i + 1) + " : " + scored[i][0] + " : " + scored[i][1]);
            res += Long.parseLong(scored[i][1]) * (i + 1);
        }
        System.out.println(res);

    }

    /**
     * Method to transform ArrayList to Array
     * @param al input ArrayList
     * @return Array
     */
    private static String[][] transformArrayList(ArrayList<String[]> al) {
        int size = al.size();
        String[][] array = new String[size][2];
        for (int i = 0; i < al.size(); i++) {
            array[i][0] = al.get(i)[0];
            array[i][1] = al.get(i)[1];
        }
        return array;
    }

    /**
     * Method for checking type of hand
     * @param s input hand
     * @param num1 first number of the same cards
     * @param num2 second number of the same cards
     * @return true if the condition of quantity of cards is met
     */
    private static boolean check(String s, int num1, int num2) {
        int n1 = 0, n2 = 0;
        String checkedChar = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int n = 0;

            if (!checkedChar.contains("" + ch)) {    // "J" is not counted!!!
                for (int j = 1; j < (s.length() - i); j++) {
                    if (ch == s.charAt(i + j) && (s.charAt(i + j) != 'J')) n = (n == 0) ? (n + 2) : (n + 1);
                }
                if (ch != 'J')
                    checkedChar += ch;
            }
            if (n != 0) {
                if (n1 == 0) n1 = n;
                else n2 = n;
            }
        }

        int nj = 0;                                // calculate quantity of "J"
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == 'J') nj++;
        }
        if (nj > 0 && nj != 5) {
            if (n1 == 0 && n2 == 0) n1 = 1 + nj;   // case with no order with "J"
            else if (n1 >= n2) n1 += nj;           // case with some order with "J"
            else n2 += nj;
        }
        if (nj == 5) n1 = 5;                       // case "JJJJJ"

        return (n1 == num1 && n2 == num2) || (n2 == num1 && n1 == num2);
    }

    // input data
    private static String data = "88788 501\n" +
            "99929 849\n" +
            "J8787 166\n" +
            "878T7 667\n" +
            "2J957 35\n" +
            "AQAA2 997\n" +
            "T6QQ5 151\n" +
            "84TJ9 142\n" +
            "AT938 566\n" +
            "A4AK7 297\n" +
            "3J383 85\n" +
            "T66TT 408\n" +
            "49J94 377\n" +
            "4AA4A 50\n" +
            "AA2K6 678\n" +
            "77758 586\n" +
            "A6J27 681\n" +
            "88TTT 554\n" +
            "JKQ26 346\n" +
            "8793J 304\n" +
            "8A53A 691\n" +
            "J6792 412\n" +
            "47QT6 21\n" +
            "65JQ5 633\n" +
            "Q2K5T 623\n" +
            "53353 985\n" +
            "AA792 205\n" +
            "52552 311\n" +
            "K6KKK 545\n" +
            "Q74Q4 756\n" +
            "KKK65 632\n" +
            "K6TTT 159\n" +
            "QTTQT 570\n" +
            "T6974 416\n" +
            "KA396 772\n" +
            "22A22 833\n" +
            "73629 293\n" +
            "3K33J 884\n" +
            "767Q6 334\n" +
            "A88J8 613\n" +
            "28789 560\n" +
            "6JT83 247\n" +
            "72629 659\n" +
            "A7J2K 456\n" +
            "K4879 197\n" +
            "QK76J 720\n" +
            "TJ923 747\n" +
            "J6664 706\n" +
            "4QTQQ 649\n" +
            "9K476 815\n" +
            "J7A77 505\n" +
            "8KK87 893\n" +
            "Q6576 718\n" +
            "6T6T2 529\n" +
            "Q39A9 426\n" +
            "J55A2 208\n" +
            "75444 96\n" +
            "8J6KJ 787\n" +
            "J244K 775\n" +
            "467J5 646\n" +
            "6KJ37 53\n" +
            "Q27T3 515\n" +
            "3QAJK 936\n" +
            "AA99A 195\n" +
            "45664 328\n" +
            "68456 376\n" +
            "56J34 557\n" +
            "9T22Q 628\n" +
            "679KK 844\n" +
            "78Q2J 824\n" +
            "3Q449 877\n" +
            "8TT82 565\n" +
            "4J596 255\n" +
            "AQ853 981\n" +
            "445KK 79\n" +
            "3KT85 589\n" +
            "6Q2A7 993\n" +
            "AJA44 179\n" +
            "TJ925 17\n" +
            "626JT 309\n" +
            "89273 471\n" +
            "J99A3 495\n" +
            "7Q945 805\n" +
            "T5JK4 193\n" +
            "TJ4J6 752\n" +
            "T63JQ 898\n" +
            "827KA 414\n" +
            "T686K 427\n" +
            "55QT3 891\n" +
            "K48AA 630\n" +
            "2T777 146\n" +
            "TKTTK 133\n" +
            "T68T8 229\n" +
            "55255 955\n" +
            "3642A 669\n" +
            "AJJQT 921\n" +
            "98AA9 647\n" +
            "Q32Q2 1000\n" +
            "44T4T 851\n" +
            "8J448 145\n" +
            "3333Q 935\n" +
            "25225 338\n" +
            "K484K 33\n" +
            "Q88T2 530\n" +
            "8QA9Q 281\n" +
            "22864 384\n" +
            "4Q5QT 757\n" +
            "7T3QT 863\n" +
            "3TA87 769\n" +
            "88686 612\n" +
            "TK2KK 880\n" +
            "TTT82 415\n" +
            "77Q77 232\n" +
            "JQ3T5 653\n" +
            "858Q4 749\n" +
            "J9K54 896\n" +
            "7JAT4 928\n" +
            "22452 176\n" +
            "3J725 522\n" +
            "694K6 721\n" +
            "8Q88Q 521\n" +
            "TATAA 181\n" +
            "6J8TQ 693\n" +
            "J54A8 122\n" +
            "73J85 13\n" +
            "9984T 90\n" +
            "444J4 173\n" +
            "99T97 907\n" +
            "35333 134\n" +
            "2A3Q5 852\n" +
            "KK77K 806\n" +
            "JJ895 937\n" +
            "37839 161\n" +
            "596TK 797\n" +
            "77T77 244\n" +
            "44774 452\n" +
            "7K557 28\n" +
            "33JTT 171\n" +
            "45JT2 878\n" +
            "9AKK2 268\n" +
            "9675K 483\n" +
            "77TJ7 274\n" +
            "55Q55 964\n" +
            "Q6666 390\n" +
            "9AT7T 931\n" +
            "KT829 716\n" +
            "AJ477 624\n" +
            "3JQ33 661\n" +
            "667Q6 464\n" +
            "47J44 6\n" +
            "J4A95 486\n" +
            "T9QK3 525\n" +
            "7A76A 767\n" +
            "749Q9 109\n" +
            "77QJA 742\n" +
            "K534A 779\n" +
            "Q88T8 451\n" +
            "T3A9K 808\n" +
            "A7AA6 513\n" +
            "6JAT7 150\n" +
            "6K88Q 314\n" +
            "444JT 829\n" +
            "5QJJ5 618\n" +
            "6TT66 534\n" +
            "6656A 57\n" +
            "65646 446\n" +
            "Q666Q 40\n" +
            "KQ2A2 140\n" +
            "A777A 675\n" +
            "TT777 830\n" +
            "T2T5T 831\n" +
            "9A799 116\n" +
            "AJJKA 130\n" +
            "53626 201\n" +
            "J44J4 126\n" +
            "J58QT 778\n" +
            "2K22K 580\n" +
            "K5KKJ 803\n" +
            "K6384 717\n" +
            "484Q7 604\n" +
            "Q9QTQ 186\n" +
            "8KJ69 916\n" +
            "323A4 726\n" +
            "77K7K 248\n" +
            "Q4987 335\n" +
            "4J87T 302\n" +
            "J7557 599\n" +
            "KKK4J 294\n" +
            "A59KJ 729\n" +
            "JQQ65 228\n" +
            "TT5QT 113\n" +
            "J799Q 49\n" +
            "28833 454\n" +
            "45J4A 502\n" +
            "3TTT3 924\n" +
            "75557 700\n" +
            "6565A 398\n" +
            "2J442 307\n" +
            "2J2J2 654\n" +
            "3AQAA 282\n" +
            "5Q282 178\n" +
            "822J2 811\n" +
            "4T9T9 453\n" +
            "377Q7 357\n" +
            "5TJ4Q 719\n" +
            "7K4KA 894\n" +
            "6T5TT 922\n" +
            "7QJ6Q 114\n" +
            "TQ38K 885\n" +
            "83A33 322\n" +
            "Q7J72 999\n" +
            "8A8AA 503\n" +
            "328KJ 342\n" +
            "9K3A4 587\n" +
            "834A8 249\n" +
            "QQK5Q 231\n" +
            "29929 391\n" +
            "8QJAQ 860\n" +
            "92QK6 705\n" +
            "Q88Q9 367\n" +
            "22422 284\n" +
            "KK96K 762\n" +
            "T47QQ 643\n" +
            "9K622 217\n" +
            "4KJ6Q 976\n" +
            "49494 547\n" +
            "T333T 405\n" +
            "57675 528\n" +
            "9A88T 845\n" +
            "A4T85 303\n" +
            "66677 239\n" +
            "763Q7 639\n" +
            "KKKJ7 601\n" +
            "5K5KK 206\n" +
            "66222 257\n" +
            "TAKTK 504\n" +
            "36636 24\n" +
            "89998 655\n" +
            "KJKJ5 713\n" +
            "QT2QQ 804\n" +
            "T6666 419\n" +
            "Q3KJT 564\n" +
            "K3K38 542\n" +
            "2K2A2 288\n" +
            "4A584 437\n" +
            "JJ4J7 932\n" +
            "7395J 792\n" +
            "J89T5 343\n" +
            "K89K6 711\n" +
            "96696 685\n" +
            "T9455 362\n" +
            "25257 238\n" +
            "6Q9J6 992\n" +
            "QA239 765\n" +
            "63736 477\n" +
            "83467 933\n" +
            "562A8 994\n" +
            "42284 187\n" +
            "J9333 491\n" +
            "K442K 3\n" +
            "KJ6Q5 78\n" +
            "Q277K 220\n" +
            "55528 20\n" +
            "8J888 318\n" +
            "4Q34Q 807\n" +
            "58J3J 18\n" +
            "686A6 332\n" +
            "5JJ25 365\n" +
            "47QA4 251\n" +
            "64J4K 433\n" +
            "KA5QK 900\n" +
            "9QQT9 36\n" +
            "77577 861\n" +
            "KJ6A2 301\n" +
            "J5AA5 286\n" +
            "K9T6Q 172\n" +
            "33737 540\n" +
            "95955 732\n" +
            "22233 665\n" +
            "2Q435 500\n" +
            "7A757 354\n" +
            "QJ375 743\n" +
            "64TKK 345\n" +
            "7J486 295\n" +
            "5Q5QQ 682\n" +
            "K5655 163\n" +
            "J56J5 112\n" +
            "229J7 709\n" +
            "69436 22\n" +
            "38839 460\n" +
            "T66J6 194\n" +
            "Q2999 211\n" +
            "6J474 15\n" +
            "33444 511\n" +
            "35A54 189\n" +
            "72TT6 773\n" +
            "7A7JK 984\n" +
            "2635T 230\n" +
            "TQ855 129\n" +
            "6K633 489\n" +
            "7K458 862\n" +
            "299J2 783\n" +
            "22322 316\n" +
            "996T2 326\n" +
            "5TK7J 188\n" +
            "KTTTT 11\n" +
            "488J8 174\n" +
            "68475 904\n" +
            "9KK99 399\n" +
            "4447T 431\n" +
            "T9AAA 541\n" +
            "4A977 131\n" +
            "59359 66\n" +
            "59QQ9 463\n" +
            "5T293 493\n" +
            "32323 736\n" +
            "J553Q 440\n" +
            "A2555 266\n" +
            "4AAAA 68\n" +
            "A3AKA 780\n" +
            "3444T 37\n" +
            "TQ77T 744\n" +
            "6J655 687\n" +
            "99AQ2 551\n" +
            "TKATA 679\n" +
            "8K4J6 879\n" +
            "3K8KJ 333\n" +
            "3Q3AJ 226\n" +
            "T67KQ 535\n" +
            "K236J 866\n" +
            "63336 934\n" +
            "648A5 484\n" +
            "4TT4T 911\n" +
            "98K56 117\n" +
            "349QT 696\n" +
            "985T4 867\n" +
            "9T339 402\n" +
            "88A8A 938\n" +
            "3J3J3 38\n" +
            "26752 177\n" +
            "JA668 29\n" +
            "KKAA7 263\n" +
            "AJAJ3 674\n" +
            "7A87T 141\n" +
            "K3J3A 558\n" +
            "3888J 199\n" +
            "6242K 989\n" +
            "3JAQQ 946\n" +
            "AA7KJ 43\n" +
            "JT623 550\n" +
            "QJQ4Q 372\n" +
            "99JJJ 386\n" +
            "83383 712\n" +
            "5K7J6 942\n" +
            "6Q639 168\n" +
            "JJ8JJ 961\n" +
            "5294A 776\n" +
            "66766 638\n" +
            "3T9JT 104\n" +
            "A7T8J 213\n" +
            "Q74J7 175\n" +
            "5296K 250\n" +
            "25888 204\n" +
            "A5AJQ 598\n" +
            "TJKK6 396\n" +
            "TTJTA 753\n" +
            "74QK4 766\n" +
            "8QTAJ 16\n" +
            "A2632 225\n" +
            "22825 823\n" +
            "J5286 606\n" +
            "999T9 533\n" +
            "22252 572\n" +
            "2Q222 98\n" +
            "55J55 684\n" +
            "K38K2 959\n" +
            "JAA4Q 908\n" +
            "49J54 55\n" +
            "7K37Q 315\n" +
            "39354 421\n" +
            "8Q76Q 730\n" +
            "666JQ 864\n" +
            "77TTK 583\n" +
            "Q9T87 846\n" +
            "44494 92\n" +
            "JJK24 909\n" +
            "AAAAK 422\n" +
            "25Q7Q 947\n" +
            "Q4658 82\n" +
            "K2Q8T 886\n" +
            "7T979 47\n" +
            "K365Q 657\n" +
            "4T822 945\n" +
            "57KK5 650\n" +
            "69555 441\n" +
            "J8J8T 960\n" +
            "KAKKK 103\n" +
            "9T5JA 479\n" +
            "88KK6 361\n" +
            "47569 209\n" +
            "39Q58 69\n" +
            "33399 271\n" +
            "9A6TK 673\n" +
            "28AAA 45\n" +
            "64449 967\n" +
            "T4J6Q 492\n" +
            "6222A 727\n" +
            "TAA72 265\n" +
            "KK667 457\n" +
            "9Q9Q6 432\n" +
            "K6K3K 300\n" +
            "5QTQQ 404\n" +
            "TJ44J 781\n" +
            "8595A 234\n" +
            "K2539 498\n" +
            "KK77J 207\n" +
            "A42Q9 602\n" +
            "23333 543\n" +
            "9J299 758\n" +
            "29222 821\n" +
            "KKTAJ 136\n" +
            "59555 856\n" +
            "5Q98Q 523\n" +
            "65558 872\n" +
            "464K6 798\n" +
            "7773K 519\n" +
            "AJAJA 380\n" +
            "77977 591\n" +
            "57443 125\n" +
            "AAJAA 450\n" +
            "5AA6A 881\n" +
            "69679 458\n" +
            "6JQ3K 139\n" +
            "Q3J3Q 636\n" +
            "AQ556 221\n" +
            "A6J3K 741\n" +
            "TT7T6 56\n" +
            "3QQQA 972\n" +
            "27399 754\n" +
            "54Q5Q 592\n" +
            "Q2975 920\n" +
            "93898 770\n" +
            "86828 27\n" +
            "TTT9T 809\n" +
            "6QA73 344\n" +
            "A8J74 546\n" +
            "J8J88 374\n" +
            "24T42 183\n" +
            "387Q6 14\n" +
            "98A99 418\n" +
            "AA3AA 245\n" +
            "44KKK 240\n" +
            "8658K 317\n" +
            "28228 555\n" +
            "2AAAA 381\n" +
            "8A2T3 331\n" +
            "75Q82 899\n" +
            "387KK 737\n" +
            "K444K 839\n" +
            "K9999 424\n" +
            "KK9AK 948\n" +
            "QQAQA 512\n" +
            "475KK 820\n" +
            "72277 430\n" +
            "JT7T3 466\n" +
            "Q555Q 853\n" +
            "5555K 562\n" +
            "QQ58J 537\n" +
            "J3762 536\n" +
            "85283 196\n" +
            "9T44T 651\n" +
            "6KTAJ 785\n" +
            "24J29 666\n" +
            "36653 962\n" +
            "KQAKA 596\n" +
            "KTK5A 597\n" +
            "Q999T 842\n" +
            "82828 629\n" +
            "AT7AT 848\n" +
            "73TT8 215\n" +
            "A4Q4Q 791\n" +
            "T8326 8\n" +
            "5QQQ7 977\n" +
            "TKKKT 680\n" +
            "A92A9 277\n" +
            "6689J 539\n" +
            "2J222 963\n" +
            "566Q8 802\n" +
            "Q9QQQ 387\n" +
            "2322A 403\n" +
            "66366 147\n" +
            "JJJJJ 951\n" +
            "278T9 496\n" +
            "6949T 465\n" +
            "3K5K8 692\n" +
            "TK3K2 608\n" +
            "AA9AA 918\n" +
            "653JK 703\n" +
            "4K5JA 475\n" +
            "63863 72\n" +
            "5593J 388\n" +
            "55474 476\n" +
            "99T9T 923\n" +
            "5A95J 825\n" +
            "T5K28 723\n" +
            "KKJJK 869\n" +
            "57865 160\n" +
            "JKKTT 272\n" +
            "AAAAT 631\n" +
            "TTJ4J 905\n" +
            "93369 214\n" +
            "8J777 944\n" +
            "96267 236\n" +
            "56Q9T 164\n" +
            "7QQ42 819\n" +
            "67K4T 434\n" +
            "AAA8A 93\n" +
            "JAJKQ 310\n" +
            "97J77 859\n" +
            "K7K9J 462\n" +
            "88JJA 283\n" +
            "74A44 25\n" +
            "KKAJK 548\n" +
            "3TT5Q 593\n" +
            "27762 914\n" +
            "TT3TT 369\n" +
            "6388Q 656\n" +
            "3T48T 156\n" +
            "AJQJ5 507\n" +
            "65K2Q 855\n" +
            "A4652 663\n" +
            "65A72 957\n" +
            "J66J6 998\n" +
            "44434 100\n" +
            "99777 449\n" +
            "3J2Q2 567\n" +
            "66QQ8 889\n" +
            "A999J 363\n" +
            "AAJJ2 364\n" +
            "7789A 350\n" +
            "73737 980\n" +
            "QQQT8 411\n" +
            "T224K 227\n" +
            "K3289 155\n" +
            "AJA77 971\n" +
            "88548 305\n" +
            "55554 76\n" +
            "38386 97\n" +
            "999A9 200\n" +
            "KJK55 7\n" +
            "J77J7 237\n" +
            "777JK 259\n" +
            "577T2 777\n" +
            "99969 407\n" +
            "9898J 761\n" +
            "225K9 722\n" +
            "9TT39 995\n" +
            "7TJ5A 745\n" +
            "45477 865\n" +
            "TTAJ4 838\n" +
            "TT22J 149\n" +
            "4J222 939\n" +
            "A8A98 84\n" +
            "8Q333 327\n" +
            "A3Q3A 897\n" +
            "29K68 575\n" +
            "5K558 621\n" +
            "58778 152\n" +
            "2923Q 107\n" +
            "4K6KJ 735\n" +
            "T9J99 115\n" +
            "33T3Q 524\n" +
            "8KKKT 91\n" +
            "33T35 397\n" +
            "QQKQT 298\n" +
            "48J36 795\n" +
            "7J777 51\n" +
            "J585A 264\n" +
            "45545 81\n" +
            "T88JT 634\n" +
            "43364 584\n" +
            "77A77 616\n" +
            "AJ4Q8 54\n" +
            "3A362 389\n" +
            "73732 755\n" +
            "68666 447\n" +
            "2Q6Q6 568\n" +
            "34K33 409\n" +
            "T5K34 60\n" +
            "TJ9T6 635\n" +
            "4QQ44 913\n" +
            "K3JK3 253\n" +
            "66A2A 686\n" +
            "KTK33 423\n" +
            "6AAAA 950\n" +
            "7554J 470\n" +
            "4444T 763\n" +
            "22772 702\n" +
            "24229 121\n" +
            "8J86K 683\n" +
            "KK7A5 474\n" +
            "6T632 987\n" +
            "2J2K2 368\n" +
            "AAJ54 611\n" +
            "QAT87 697\n" +
            "J9QQ8 740\n" +
            "92QQ2 688\n" +
            "6TKA8 184\n" +
            "QQQQA 202\n" +
            "A5JJ3 890\n" +
            "3T445 590\n" +
            "93995 348\n" +
            "6QQJ3 873\n" +
            "T4TJ4 841\n" +
            "2T2TT 269\n" +
            "K8J7T 223\n" +
            "89999 958\n" +
            "Q77J6 379\n" +
            "TT2TT 2\n" +
            "6JQ29 280\n" +
            "8TQT8 615\n" +
            "6TTTT 978\n" +
            "T6A66 517\n" +
            "77884 439\n" +
            "33633 494\n" +
            "T99T5 153\n" +
            "7T54J 953\n" +
            "33739 65\n" +
            "4K544 556\n" +
            "9Q9J9 751\n" +
            "8QQ79 637\n" +
            "2QQ69 786\n" +
            "TKJ2K 930\n" +
            "56545 41\n" +
            "5A8A4 676\n" +
            "66566 868\n" +
            "69996 915\n" +
            "JJQQQ 9\n" +
            "J27KJ 499\n" +
            "22424 26\n" +
            "64QQ4 323\n" +
            "988A8 123\n" +
            "7K447 410\n" +
            "T8K8T 620\n" +
            "7KAJK 573\n" +
            "88855 531\n" +
            "75743 943\n" +
            "KT7KK 578\n" +
            "J3A56 708\n" +
            "3224A 158\n" +
            "J73J2 290\n" +
            "79955 858\n" +
            "58JK5 640\n" +
            "A4AJJ 340\n" +
            "33J44 648\n" +
            "95785 527\n" +
            "3K548 965\n" +
            "K47J4 552\n" +
            "9QQJQ 275\n" +
            "J85Q7 75\n" +
            "64466 461\n" +
            "478KQ 132\n" +
            "88989 828\n" +
            "T2T22 710\n" +
            "38A22 442\n" +
            "8QJJ8 704\n" +
            "K4KKK 325\n" +
            "29942 875\n" +
            "3AK56 210\n" +
            "388K6 31\n" +
            "82233 182\n" +
            "A9ATT 968\n" +
            "AJK46 906\n" +
            "699T9 218\n" +
            "33338 353\n" +
            "55J33 664\n" +
            "8J868 901\n" +
            "44249 927\n" +
            "KTT7J 800\n" +
            "8TA2Q 137\n" +
            "88928 313\n" +
            "AA5A9 472\n" +
            "5AAAA 406\n" +
            "23JJQ 627\n" +
            "79JA2 585\n" +
            "Q6J99 919\n" +
            "3J444 952\n" +
            "3KKKK 19\n" +
            "7QQTK 812\n" +
            "8QJ83 48\n" +
            "2252Q 892\n" +
            "65556 480\n" +
            "3336A 731\n" +
            "976JK 672\n" +
            "QAAAQ 561\n" +
            "J69J9 510\n" +
            "K7777 355\n" +
            "Q8888 58\n" +
            "Q8QJ8 887\n" +
            "88848 843\n" +
            "KKJ35 903\n" +
            "92988 986\n" +
            "33344 62\n" +
            "55JK3 241\n" +
            "K37Q5 847\n" +
            "TAA7K 428\n" +
            "A33AA 349\n" +
            "2K222 222\n" +
            "9AK56 563\n" +
            "QT382 644\n" +
            "KK2T2 488\n" +
            "AA552 715\n" +
            "96A37 262\n" +
            "3J376 949\n" +
            "JTJJT 594\n" +
            "KKQJK 448\n" +
            "999JJ 71\n" +
            "8556A 74\n" +
            "Q4JJQ 292\n" +
            "55JK6 366\n" +
            "444Q4 724\n" +
            "7QK58 940\n" +
            "K2J8T 559\n" +
            "9T96T 312\n" +
            "Q679A 73\n" +
            "33A37 870\n" +
            "93TJA 734\n" +
            "44489 191\n" +
            "9TA9A 478\n" +
            "66K5K 836\n" +
            "A8J8A 119\n" +
            "322K2 59\n" +
            "777TA 111\n" +
            "A7778 609\n" +
            "AJK96 83\n" +
            "TTJ5T 827\n" +
            "3QQQ3 514\n" +
            "32242 595\n" +
            "T5JT5 652\n" +
            "544J5 996\n" +
            "884QK 467\n" +
            "7737J 12\n" +
            "Q5TA9 538\n" +
            "8J5J8 401\n" +
            "68KQ9 569\n" +
            "9QKJK 1\n" +
            "AAAJ8 801\n" +
            "3333J 888\n" +
            "7Q979 373\n" +
            "77277 252\n" +
            "AKKQQ 394\n" +
            "QTJ47 695\n" +
            "JJJT7 793\n" +
            "A27A5 358\n" +
            "99939 148\n" +
            "8T7J8 738\n" +
            "Q9924 438\n" +
            "73763 607\n" +
            "KJT44 127\n" +
            "8T288 975\n" +
            "64K4K 279\n" +
            "6A6JA 925\n" +
            "56555 110\n" +
            "77427 671\n" +
            "9956J 941\n" +
            "7757J 359\n" +
            "J3337 80\n" +
            "44256 642\n" +
            "JJ555 871\n" +
            "55859 784\n" +
            "896TK 324\n" +
            "66K66 336\n" +
            "2Q2QQ 750\n" +
            "93833 87\n" +
            "5JA3K 689\n" +
            "TQKQ3 395\n" +
            "K8334 308\n" +
            "22A42 983\n" +
            "533JA 974\n" +
            "9J7T7 455\n" +
            "8888T 840\n" +
            "TAT95 370\n" +
            "22T22 509\n" +
            "TKQJ7 581\n" +
            "48448 641\n" +
            "J3993 102\n" +
            "TQ8A5 270\n" +
            "2KT39 291\n" +
            "TQTTT 445\n" +
            "J2A5T 89\n" +
            "2KQ98 170\n" +
            "A5AA5 520\n" +
            "QJT8T 571\n" +
            "J7AAA 733\n" +
            "227A2 61\n" +
            "T555T 973\n" +
            "TT63A 436\n" +
            "48JA6 420\n" +
            "788K9 690\n" +
            "2A2K4 260\n" +
            "3TJTT 759\n" +
            "74K87 506\n" +
            "45Q22 400\n" +
            "228J8 771\n" +
            "AJJ2T 52\n" +
            "9274T 610\n" +
            "T4TQT 956\n" +
            "JTT66 790\n" +
            "4344K 508\n" +
            "8878A 243\n" +
            "55666 788\n" +
            "5A2Q5 768\n" +
            "77T78 296\n" +
            "KJK59 360\n" +
            "TTTJT 954\n" +
            "952J9 603\n" +
            "J6666 487\n" +
            "JTJ29 32\n" +
            "9A278 516\n" +
            "933AA 874\n" +
            "57357 835\n" +
            "334AJ 287\n" +
            "J4KK4 276\n" +
            "J2226 698\n" +
            "49999 382\n" +
            "Q6QQ2 549\n" +
            "6A4J3 670\n" +
            "8QJA2 826\n" +
            "999K7 138\n" +
            "K7Q87 242\n" +
            "22226 413\n" +
            "7K9K8 285\n" +
            "A85AA 299\n" +
            "2JJK2 385\n" +
            "Q3TTQ 5\n" +
            "377QT 902\n" +
            "82223 63\n" +
            "QQ7Q6 64\n" +
            "9J7JQ 469\n" +
            "7A7TT 970\n" +
            "45JJ2 162\n" +
            "82J4T 383\n" +
            "9AA99 748\n" +
            "53K53 794\n" +
            "K2KKK 982\n" +
            "646J3 330\n" +
            "26J27 216\n" +
            "87A26 605\n" +
            "343J5 966\n" +
            "QQ4QQ 622\n" +
            "9JTQ9 912\n" +
            "A3A38 337\n" +
            "T2538 34\n" +
            "52553 224\n" +
            "66622 444\n" +
            "5T5TT 701\n" +
            "8JJKJ 895\n" +
            "A333A 101\n" +
            "KK5QQ 694\n" +
            "J9999 979\n" +
            "KTKT7 668\n" +
            "QQ622 725\n" +
            "55Q7K 77\n" +
            "79TK8 392\n" +
            "JJ98A 352\n" +
            "2A332 883\n" +
            "33T39 834\n" +
            "94J73 212\n" +
            "Q22QJ 267\n" +
            "53A9A 67\n" +
            "69666 169\n" +
            "KAJAT 95\n" +
            "QQ84Q 728\n" +
            "63723 774\n" +
            "Q3A8K 375\n" +
            "3J36Q 625\n" +
            "85J88 714\n" +
            "5T9J3 124\n" +
            "2KK2K 614\n" +
            "Q5JKJ 988\n" +
            "68926 203\n" +
            "TQ799 822\n" +
            "46TT4 44\n" +
            "97997 482\n" +
            "2A282 106\n" +
            "6TQ88 459\n" +
            "33999 707\n" +
            "7Q264 574\n" +
            "AAAA7 739\n" +
            "86888 154\n" +
            "A752J 10\n" +
            "2T727 760\n" +
            "5T54T 662\n" +
            "2QQQQ 626\n" +
            "6797J 143\n" +
            "6K56T 105\n" +
            "679Q8 88\n" +
            "8AK25 579\n" +
            "K6AJK 645\n" +
            "8J83J 746\n" +
            "A7AA2 854\n" +
            "9J2TQ 319\n" +
            "A8J84 577\n" +
            "87787 799\n" +
            "867AJ 837\n" +
            "QQJQQ 796\n" +
            "QQTQQ 576\n" +
            "225T5 588\n" +
            "5QQ77 677\n" +
            "K7KKK 969\n" +
            "T7TTT 832\n" +
            "A4AA6 192\n" +
            "KQ987 190\n" +
            "ATTAT 425\n" +
            "6J9A4 378\n" +
            "99Q2J 128\n" +
            "95549 917\n" +
            "KKQKK 180\n" +
            "6A5Q7 254\n" +
            "8378J 991\n" +
            "64444 553\n" +
            "JTTJT 789\n" +
            "J75K5 810\n" +
            "QQK28 258\n" +
            "4K3J6 518\n" +
            "2TTT7 135\n" +
            "K3339 532\n" +
            "27222 94\n" +
            "29A29 857\n" +
            "49882 351\n" +
            "63J33 198\n" +
            "5T5J7 910\n" +
            "7443K 185\n" +
            "4K44J 393\n" +
            "K6626 417\n" +
            "28888 347\n" +
            "T47KT 882\n" +
            "22562 273\n" +
            "K8627 118\n" +
            "Q92KK 926\n" +
            "J2644 600\n" +
            "AA6T7 86\n" +
            "2QQ22 929\n" +
            "447J7 246\n" +
            "J8A25 167\n" +
            "2A898 468\n" +
            "46K55 660\n" +
            "JTTT9 23\n" +
            "QQQ7Q 219\n" +
            "7Q7JQ 42\n" +
            "77A37 108\n" +
            "33244 850\n" +
            "Q8529 46\n" +
            "82A5Q 443\n" +
            "76877 278\n" +
            "A7J3T 320\n" +
            "QKT4K 782\n" +
            "57AJA 99\n" +
            "8Q3J3 39\n" +
            "KA4QQ 582\n" +
            "KKKJK 481\n" +
            "66864 876\n" +
            "KK3K3 816\n" +
            "Q8853 813\n" +
            "223T6 544\n" +
            "KAKTK 261\n" +
            "99Q9A 764\n" +
            "Q7425 235\n" +
            "A86K5 321\n" +
            "J483K 435\n" +
            "KK8KK 339\n" +
            "A52TQ 30\n" +
            "TAA37 473\n" +
            "K4AAK 658\n" +
            "KK48A 429\n" +
            "64484 497\n" +
            "3K3TA 289\n" +
            "8898J 144\n" +
            "JAJAJ 356\n" +
            "K8286 329\n" +
            "82KQ6 818\n" +
            "55T55 814\n" +
            "7KA9Q 619\n" +
            "727A7 817\n" +
            "893J3 485\n" +
            "452J5 371\n" +
            "K6969 256\n" +
            "5J528 490\n" +
            "77498 990\n" +
            "6J86K 699\n" +
            "J9373 526\n" +
            "KQQKK 157\n" +
            "77AA2 120\n" +
            "J488Q 165\n" +
            "63885 4\n" +
            "T94K3 233\n" +
            "AA4JA 306\n" +
            "7QQ9J 617\n" +
            "88KKK 70\n" +
            "485QT 341";
}

