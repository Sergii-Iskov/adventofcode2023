package com.shpp.p2p.cs.siskov.adventofcode;

import java.util.HashMap;

/**
 * This task "Day 8: Haunted Wasteland" is from https://adventofcode.com/2023/day/8
 * We need to calculate How many steps does it take before you're only on nodes that end with Z.
 * Use long (very long!!!) calculation - step by step
 * Created by Sergii Iskov, 2023. Version 2.0
 */
public class day8bLong {
    public static void main(String[] args) {
        String[] dataArr = data.split("\n");
        HashMap<String, String[]> dataMap = fillMap(dataArr);
        String[] resultArr = new String[6];
        int count = 0;
        // find start points
        for (String key : dataMap.keySet()) {
            if (key.charAt(2) == 'A') {
                resultArr[count] = key;
                count++;
            }
        }

        // and go - step by step
        int step = 0;
        while (true) {
            char ch = instruction.charAt(step);
            for (int i = 0; i < resultArr.length; i++) {
                if (ch == 'L') resultArr[i] = dataMap.get(resultArr[i])[0];
                if (ch == 'R') resultArr[i] = dataMap.get(resultArr[i])[1];
            }
            step++;
            if (step == instruction.length()) instruction += instruction;

            // check on "Z"
            int countZ = 0;
            for (int i = 0; i < resultArr.length; i++) {
                if (resultArr[i].charAt(2) == 'Z') {
                    countZ++;
                    System.out.println(" \n " + (i + 1) + " = " + resultArr[i] + "    count  = " + countZ + "\n ");
                }
            }
            System.out.println("Step " + step + " 1) " + resultArr[0] + " 2) " + resultArr[1] +
                    " 3) " + resultArr[2] + " 4) " + resultArr[3] + " 5) "+ resultArr[4] + " 6) " + resultArr[5]);
            if (countZ == 6) break;
        }
        System.out.println("Step = " + step);
    }

    private static HashMap<String, String[]> fillMap(String[] arr) {
        HashMap<String, String[]> map = new HashMap<>();
        for (String s : arr) {
            String key = s.split("=")[0].trim();
            String valueL = s.split("=")[1].trim().split(",")[0].substring(1, 4);
            String valueR = s.split("=")[1].trim().split(",")[1].substring(1, 4);
            String[] element = {valueL, valueR};
            map.put(key, element);
        }
        return map;
    }

    private static String instruction = "LRLRLRLRRLRRRLRLRLRRRLLRRLRRLRRLLRRLRRLRLRRRLRRLLRRLRRRLRRLRRRLRRRLLLRRLLRLLRRRLLRRLRLLRLLRRRLLRRLRRLRRRLRRLRLRRLRRLRLLRLRRRLRLRRLRLLRRLRRRLRRLRLRRLLLRRLRRRLRRRLRRLRRRLRLRRLRRLRRRLRRLRRLRRLRRLRRRLLRRRLLLRRRLRRLRRRLLRRRLRRLRRLLLLLRRRLRLRRLRRLLRRLRRLRLRLRRRLRRRLRRLLLRRRR";
    private static String data = "BPQ = (VXR, TLN)\n" +
            "NSK = (FRM, GXV)\n" +
            "XVG = (BBC, SGF)\n" +
            "JTG = (LVR, MPK)\n" +
            "RNQ = (TMP, TLT)\n" +
            "VVX = (TVH, GCM)\n" +
            "DJH = (MMH, LLQ)\n" +
            "LQR = (HFF, FHP)\n" +
            "QFQ = (CFT, STF)\n" +
            "RJL = (TFG, CTR)\n" +
            "DRB = (GBQ, NRB)\n" +
            "KHK = (XDB, DVQ)\n" +
            "NCG = (SHP, LTM)\n" +
            "KSD = (KQT, PDB)\n" +
            "MGL = (LDG, DCN)\n" +
            "KFX = (HLG, VGF)\n" +
            "KFG = (JGB, GVH)\n" +
            "JLV = (CGX, MQN)\n" +
            "CCB = (JXL, LHD)\n" +
            "CSJ = (GQS, FHJ)\n" +
            "VPX = (RGL, XMD)\n" +
            "CHV = (DHP, DKG)\n" +
            "LRV = (MLC, HQQ)\n" +
            "BPJ = (QJP, VLR)\n" +
            "VFF = (PSS, NFD)\n" +
            "FCM = (JBG, NRK)\n" +
            "GBQ = (JRQ, TLQ)\n" +
            "VLM = (KRH, BMQ)\n" +
            "GXS = (TKS, TQZ)\n" +
            "NNM = (LDG, DCN)\n" +
            "QVN = (TMP, TLT)\n" +
            "JCR = (GLG, KFV)\n" +
            "MFM = (MXN, PMM)\n" +
            "GLG = (JSK, HHT)\n" +
            "LGH = (RXD, NDN)\n" +
            "CRH = (MCD, DSJ)\n" +
            "FDD = (XTR, QSS)\n" +
            "QQX = (XPS, XPS)\n" +
            "XGF = (LPL, PMR)\n" +
            "DFG = (FTR, JTK)\n" +
            "HHV = (KHK, QDJ)\n" +
            "LDX = (GBP, RFP)\n" +
            "JJD = (SNC, CST)\n" +
            "CGG = (VXR, TLN)\n" +
            "VQB = (LBM, RBD)\n" +
            "QRT = (DJH, BKC)\n" +
            "KFP = (SVN, SCG)\n" +
            "BKC = (LLQ, MMH)\n" +
            "KJF = (BGB, CTL)\n" +
            "VDL = (XFX, QGQ)\n" +
            "JNN = (CSX, JQX)\n" +
            "LDV = (TTQ, CQR)\n" +
            "SJD = (QNM, NSK)\n" +
            "RPD = (XFQ, SKS)\n" +
            "BMR = (MRH, RSM)\n" +
            "CNK = (QQK, DHQ)\n" +
            "MLD = (MNC, BQT)\n" +
            "PQS = (VLN, LJC)\n" +
            "HKK = (RQP, VGD)\n" +
            "QCS = (KVD, XPB)\n" +
            "KVD = (QRT, TVP)\n" +
            "JMK = (BLV, PQS)\n" +
            "CJF = (KPD, GRJ)\n" +
            "DTG = (TCX, LVM)\n" +
            "DQG = (GQQ, CQK)\n" +
            "VNN = (QNF, CDC)\n" +
            "SHV = (LLV, QNQ)\n" +
            "HQQ = (VNN, XPG)\n" +
            "LVM = (LQH, NVM)\n" +
            "VFP = (VPX, MRG)\n" +
            "SBG = (PXL, LNC)\n" +
            "PXL = (PCQ, RVK)\n" +
            "CXH = (SBL, SKV)\n" +
            "HTM = (PPF, RCT)\n" +
            "GBP = (JMX, JMX)\n" +
            "QMN = (BSJ, NBP)\n" +
            "DDJ = (LRF, NHV)\n" +
            "QMS = (GNT, DMH)\n" +
            "QDG = (CSF, NSB)\n" +
            "VGR = (QMS, BXX)\n" +
            "MCB = (SSQ, KNF)\n" +
            "JVL = (PCC, MQX)\n" +
            "RCQ = (PQP, CMP)\n" +
            "NQK = (KXG, DQR)\n" +
            "CFT = (QHQ, XKH)\n" +
            "CMP = (NPS, DXN)\n" +
            "KKV = (BPJ, QBG)\n" +
            "SGF = (CTP, KKQ)\n" +
            "BKL = (RCR, NFS)\n" +
            "JHN = (CGN, SHV)\n" +
            "GLB = (HMC, NFQ)\n" +
            "QTG = (FRF, LMN)\n" +
            "NFS = (LQX, KCL)\n" +
            "RNK = (QCB, BRJ)\n" +
            "KLX = (VST, SVR)\n" +
            "SMK = (JSJ, QTG)\n" +
            "KQJ = (FNS, NPD)\n" +
            "CQR = (JNC, BKP)\n" +
            "MCP = (HLM, SLC)\n" +
            "HMP = (QRN, BDN)\n" +
            "DQJ = (CNK, GSR)\n" +
            "XFD = (HMV, XPR)\n" +
            "BDB = (PQS, BLV)\n" +
            "BXG = (CHV, VVM)\n" +
            "CGN = (QNQ, LLV)\n" +
            "JDB = (FCS, FBX)\n" +
            "XFC = (MJT, QML)\n" +
            "PMR = (SJD, TGD)\n" +
            "GVP = (SBS, KJF)\n" +
            "XPS = (DQJ, DQJ)\n" +
            "KCF = (HCT, DBS)\n" +
            "KRH = (GDD, KLX)\n" +
            "FDT = (LHD, JXL)\n" +
            "VLH = (VJP, NCG)\n" +
            "JNC = (HPT, VDQ)\n" +
            "JMX = (MVJ, MVJ)\n" +
            "RKN = (CJF, CJF)\n" +
            "PFS = (LHB, FDD)\n" +
            "QXG = (RLP, DXM)\n" +
            "CTL = (JVX, MVN)\n" +
            "CTP = (JNG, VFP)\n" +
            "FBK = (DQL, KKX)\n" +
            "XBH = (XQK, LMV)\n" +
            "RXH = (DHM, DHM)\n" +
            "XNN = (NPM, GJF)\n" +
            "SKS = (XJP, MQL)\n" +
            "RNC = (FKF, RGS)\n" +
            "HNT = (NTV, RSG)\n" +
            "RCR = (LQX, KCL)\n" +
            "LMN = (PDT, QXG)\n" +
            "DGK = (QQX, RCK)\n" +
            "QGS = (GKL, PHD)\n" +
            "JSJ = (LMN, FRF)\n" +
            "JNG = (MRG, VPX)\n" +
            "KHF = (MHR, RDM)\n" +
            "MQX = (MKS, LRQ)\n" +
            "BXN = (LMV, XQK)\n" +
            "RCT = (DRK, QKJ)\n" +
            "NGL = (MMQ, JNN)\n" +
            "LXL = (RCH, TJF)\n" +
            "MVN = (NLN, CCC)\n" +
            "KGQ = (DML, VCT)\n" +
            "SVN = (DBR, JJD)\n" +
            "BKQ = (XKJ, JNM)\n" +
            "LCA = (CNK, GSR)\n" +
            "HHB = (HMK, HJP)\n" +
            "NHB = (BVP, JBL)\n" +
            "SXD = (SKC, RDJ)\n" +
            "TCX = (LQH, NVM)\n" +
            "CST = (QTC, KVK)\n" +
            "QRN = (RPD, QQF)\n" +
            "MXS = (DQG, NJC)\n" +
            "DPN = (LRV, DGH)\n" +
            "LJJ = (TSP, SKL)\n" +
            "LRF = (XFD, CKQ)\n" +
            "RSG = (QDL, GCD)\n" +
            "JBC = (SLC, HLM)\n" +
            "RVK = (RBM, JRP)\n" +
            "XQG = (DGH, LRV)\n" +
            "QDJ = (DVQ, XDB)\n" +
            "SMT = (BHN, KTM)\n" +
            "TPF = (SFV, BVD)\n" +
            "LGS = (RSQ, JCR)\n" +
            "DMB = (CRH, FQD)\n" +
            "LVN = (QMS, BXX)\n" +
            "MVJ = (TKS, TKS)\n" +
            "VXR = (RBP, RCQ)\n" +
            "CSX = (TNJ, DJG)\n" +
            "TVH = (RXH, RXH)\n" +
            "DXM = (LPF, LSS)\n" +
            "HCT = (KFX, CMC)\n" +
            "LHB = (QSS, XTR)\n" +
            "XNQ = (DQJ, XCZ)\n" +
            "NHK = (PDQ, FLN)\n" +
            "DKT = (QCL, QCL)\n" +
            "BVV = (JNN, MMQ)\n" +
            "XHP = (DDJ, SQN)\n" +
            "LMK = (LTK, MPV)\n" +
            "NNH = (NKM, KGQ)\n" +
            "CFG = (DPN, XQG)\n" +
            "BLM = (CNQ, KJX)\n" +
            "JKS = (MFX, VVF)\n" +
            "DHM = (XVL, XVL)\n" +
            "DRK = (LXL, PCH)\n" +
            "TLC = (TPQ, FRJ)\n" +
            "KPF = (SHL, NQH)\n" +
            "CCQ = (JMK, BDB)\n" +
            "LQK = (CGG, BPQ)\n" +
            "SHL = (FQG, XLS)\n" +
            "MJV = (PNF, PNF)\n" +
            "TNJ = (KSD, DHX)\n" +
            "QDL = (GJH, CMX)\n" +
            "BVF = (HNT, CPM)\n" +
            "KSB = (BPH, MXS)\n" +
            "FFB = (SFV, BVD)\n" +
            "PMM = (LSV, FCM)\n" +
            "JRQ = (LDV, FRP)\n" +
            "VMH = (BPJ, QBG)\n" +
            "KPD = (KBG, PFQ)\n" +
            "GRT = (KKX, DQL)\n" +
            "NJF = (DCG, MNK)\n" +
            "HMC = (VVX, VCD)\n" +
            "NTV = (QDL, GCD)\n" +
            "GVH = (LRR, HRC)\n" +
            "NCL = (LVN, VGR)\n" +
            "JRV = (QBQ, HJF)\n" +
            "FRF = (PDT, QXG)\n" +
            "NXP = (CGN, SHV)\n" +
            "JPR = (GBQ, NRB)\n" +
            "RFP = (JMX, VSH)\n" +
            "QCB = (GBT, BHR)\n" +
            "MBT = (NPD, FNS)\n" +
            "DTH = (VGR, LVN)\n" +
            "GRJ = (KBG, PFQ)\n" +
            "NPS = (FVB, FHL)\n" +
            "VVM = (DKG, DHP)\n" +
            "TRT = (KKV, VMH)\n" +
            "JSP = (NRT, NKC)\n" +
            "VLR = (RJL, NQR)\n" +
            "PPZ = (QKG, HCB)\n" +
            "VHV = (DRC, KMB)\n" +
            "BGG = (DDJ, SQN)\n" +
            "CSF = (MLD, BTC)\n" +
            "QQF = (XFQ, SKS)\n" +
            "FTM = (CNQ, KJX)\n" +
            "KKJ = (RPC, RRK)\n" +
            "QTV = (HFN, FXJ)\n" +
            "RRL = (JDH, TMT)\n" +
            "LTT = (HHV, KTD)\n" +
            "TBP = (SNF, RMH)\n" +
            "MCD = (FMM, DFG)\n" +
            "PQQ = (XFC, DSS)\n" +
            "HMV = (PHH, MXL)\n" +
            "QCL = (LCN, LCN)\n" +
            "MVX = (SSQ, KNF)\n" +
            "DXN = (FVB, FHL)\n" +
            "SKR = (RCR, NFS)\n" +
            "BVP = (BMR, JVJ)\n" +
            "NBP = (LTT, DBK)\n" +
            "HPT = (JKS, GNS)\n" +
            "LPL = (SJD, TGD)\n" +
            "RSQ = (GLG, KFV)\n" +
            "NBQ = (BPL, HGH)\n" +
            "PQP = (NPS, DXN)\n" +
            "LSS = (NHB, XVP)\n" +
            "CKL = (MCB, MVX)\n" +
            "LQX = (TPF, FFB)\n" +
            "TGD = (NSK, QNM)\n" +
            "FRP = (TTQ, CQR)\n" +
            "RCH = (CCB, FDT)\n" +
            "VVL = (RDJ, SKC)\n" +
            "NVA = (KPD, GRJ)\n" +
            "FMM = (FTR, JTK)\n" +
            "KPM = (MQX, PCC)\n" +
            "QXQ = (QDT, JLV)\n" +
            "JVJ = (MRH, RSM)\n" +
            "SMN = (HPX, CDM)\n" +
            "XTP = (LLD, QBC)\n" +
            "BVB = (JCR, RSQ)\n" +
            "JTN = (TND, JFQ)\n" +
            "CLK = (QXB, BGQ)\n" +
            "NMX = (FTM, BLM)\n" +
            "QKH = (BHN, KTM)\n" +
            "VJP = (SHP, LTM)\n" +
            "FNS = (SNX, GPP)\n" +
            "DGH = (MLC, HQQ)\n" +
            "NFM = (CVD, CTD)\n" +
            "NKM = (DML, VCT)\n" +
            "HMK = (FDX, SMK)\n" +
            "VVQ = (FDD, LHB)\n" +
            "FDX = (QTG, JSJ)\n" +
            "MKL = (TDX, DLC)\n" +
            "HQX = (GHS, LTX)\n" +
            "KJX = (MQB, CTV)\n" +
            "PHD = (NHK, PGQ)\n" +
            "KDF = (TDD, PJM)\n" +
            "MTK = (LCN, ZZZ)\n" +
            "NVM = (LCC, MKL)\n" +
            "XSH = (MJV, FRD)\n" +
            "LLQ = (GRS, CFG)\n" +
            "TGP = (XCK, MNR)\n" +
            "XVJ = (VLH, TTX)\n" +
            "PLR = (VVL, SXD)\n" +
            "CTR = (DHV, VFQ)\n" +
            "KKQ = (VFP, JNG)\n" +
            "BMQ = (GDD, KLX)\n" +
            "VVF = (LCV, MGX)\n" +
            "PGQ = (FLN, PDQ)\n" +
            "SSC = (MRN, JTG)\n" +
            "TDD = (HTB, TBP)\n" +
            "QKJ = (PCH, LXL)\n" +
            "GXV = (BXN, XBH)\n" +
            "MRG = (RGL, XMD)\n" +
            "KXJ = (NXP, JHN)\n" +
            "NFD = (NJF, BQP)\n" +
            "GSS = (HPP, HQX)\n" +
            "XDC = (JFC, JFC)\n" +
            "PNF = (MGL, NNM)\n" +
            "SQN = (LRF, NHV)\n" +
            "HJP = (FDX, SMK)\n" +
            "RBM = (HHB, LTN)\n" +
            "CRM = (RBD, LBM)\n" +
            "DBR = (CST, SNC)\n" +
            "NQR = (CTR, TFG)\n" +
            "GQS = (GVR, CFJ)\n" +
            "JSK = (FVF, VLM)\n" +
            "KHR = (DHM, GXN)\n" +
            "QST = (VCJ, LNT)\n" +
            "DQH = (NCV, LQR)\n" +
            "PCQ = (JRP, RBM)\n" +
            "MMH = (CFG, GRS)\n" +
            "FHP = (CSS, NNH)\n" +
            "BGB = (JVX, MVN)\n" +
            "RCK = (XPS, XNQ)\n" +
            "XGR = (NCH, GLV)\n" +
            "GCD = (CMX, GJH)\n" +
            "HJF = (NBF, TQF)\n" +
            "DRC = (LFP, FFR)\n" +
            "RGL = (BJR, DKP)\n" +
            "RSM = (LDX, HQB)\n" +
            "BTC = (BQT, MNC)\n" +
            "SRV = (SBL, SKV)\n" +
            "NFG = (JVT, SSC)\n" +
            "CGX = (BVK, XLG)\n" +
            "QFH = (KDR, LGT)\n" +
            "VCT = (JJF, DGK)\n" +
            "LBM = (PKL, SGH)\n" +
            "MKS = (QGF, JRV)\n" +
            "QSG = (LTK, MPV)\n" +
            "GGT = (BGG, XHP)\n" +
            "GVR = (VRD, CQJ)\n" +
            "GPD = (HQX, HPP)\n" +
            "LLD = (KDK, XVJ)\n" +
            "DCG = (LRN, XSS)\n" +
            "DSJ = (DFG, FMM)\n" +
            "XMD = (DKP, BJR)\n" +
            "MNK = (LRN, XSS)\n" +
            "FTT = (SVN, SCG)\n" +
            "CMX = (SRN, XSC)\n" +
            "XVP = (BVP, JBL)\n" +
            "BQP = (DCG, MNK)\n" +
            "RTM = (KHF, QPJ)\n" +
            "FFR = (KPV, XTP)\n" +
            "VLN = (PJQ, KTF)\n" +
            "JQX = (TNJ, DJG)\n" +
            "KTF = (PDG, KDF)\n" +
            "JVH = (LNC, PXL)\n" +
            "BPH = (NJC, DQG)\n" +
            "MFJ = (XHD, VFF)\n" +
            "CDC = (DLK, KMF)\n" +
            "MXN = (LSV, FCM)\n" +
            "LGT = (MPB, PNG)\n" +
            "XFT = (RCT, PPF)\n" +
            "BSJ = (DBK, LTT)\n" +
            "BVT = (JSP, QVG)\n" +
            "QBC = (XVJ, KDK)\n" +
            "VRD = (LFG, FHF)\n" +
            "KQT = (GVP, VGJ)\n" +
            "CSS = (NKM, KGQ)\n" +
            "HXL = (DTH, NCL)\n" +
            "FXJ = (DRB, JPR)\n" +
            "FFT = (JVT, SSC)\n" +
            "NJH = (NQK, BJM)\n" +
            "GHS = (CLL, NJH)\n" +
            "MMQ = (JQX, CSX)\n" +
            "PGD = (FKF, RGS)\n" +
            "PJQ = (KDF, PDG)\n" +
            "LFG = (KSB, CMM)\n" +
            "LRN = (BVF, KSQ)\n" +
            "GGX = (JSS, MTS)\n" +
            "LCC = (TDX, DLC)\n" +
            "HPP = (LTX, GHS)\n" +
            "CLL = (BJM, NQK)\n" +
            "TPQ = (XTC, TGP)\n" +
            "BQQ = (CHV, VVM)\n" +
            "PVJ = (LNT, VCJ)\n" +
            "QNQ = (QTV, CMH)\n" +
            "CVD = (XGF, NBH)\n" +
            "JVT = (MRN, JTG)\n" +
            "VFQ = (BXS, FCG)\n" +
            "CPM = (NTV, RSG)\n" +
            "QNF = (DLK, KMF)\n" +
            "GCA = (MGL, NNM)\n" +
            "MGX = (TFX, XNN)\n" +
            "MHR = (NJX, DNT)\n" +
            "KTM = (GDK, MQS)\n" +
            "KDR = (MPB, PNG)\n" +
            "NDF = (XXP, CJB)\n" +
            "ZZZ = (SKQ, JKJ)\n" +
            "MQL = (FBK, GRT)\n" +
            "NHV = (CKQ, XFD)\n" +
            "NBH = (PMR, LPL)\n" +
            "KCL = (FFB, TPF)\n" +
            "BJR = (FTB, KXR)\n" +
            "XSM = (QCL, MTK)\n" +
            "KBG = (QSG, LMK)\n" +
            "SKC = (NBQ, DKC)\n" +
            "PNG = (CNM, LQK)\n" +
            "HTB = (RMH, SNF)\n" +
            "RDM = (NJX, DNT)\n" +
            "FRM = (BXN, XBH)\n" +
            "XTC = (MNR, XCK)\n" +
            "JVX = (NLN, CCC)\n" +
            "GVQ = (CDM, HPX)\n" +
            "SCG = (JJD, DBR)\n" +
            "CCC = (CMR, NKL)\n" +
            "SNC = (KVK, QTC)\n" +
            "GJF = (BHB, GGT)\n" +
            "BJK = (JPS, BKQ)\n" +
            "PCC = (LRQ, MKS)\n" +
            "RBV = (PVJ, QST)\n" +
            "KMF = (BQQ, BXG)\n" +
            "KSQ = (HNT, CPM)\n" +
            "LPN = (CJB, XXP)\n" +
            "DLK = (BXG, BQQ)\n" +
            "MPB = (CNM, LQK)\n" +
            "VSH = (MVJ, GXS)\n" +
            "QBQ = (NBF, TQF)\n" +
            "XLG = (LNF, KCF)\n" +
            "LRQ = (QGF, JRV)\n" +
            "PVQ = (SGF, BBC)\n" +
            "DSS = (MJT, QML)\n" +
            "TLQ = (FRP, LDV)\n" +
            "DHC = (XFC, DSS)\n" +
            "FRD = (PNF, SFZ)\n" +
            "HGH = (STV, VDL)\n" +
            "FHL = (FNC, TJJ)\n" +
            "DHQ = (XGR, NMN)\n" +
            "BRJ = (BHR, GBT)\n" +
            "CQJ = (FHF, LFG)\n" +
            "KDK = (TTX, VLH)\n" +
            "QJP = (NQR, RJL)\n" +
            "GCM = (RXH, KHR)\n" +
            "TFM = (GGR, BVT)\n" +
            "NKL = (JHH, CKL)\n" +
            "PFQ = (LMK, QSG)\n" +
            "XXP = (RBV, QRP)\n" +
            "PJM = (TBP, HTB)\n" +
            "LDG = (GVQ, SMN)\n" +
            "GNS = (VVF, MFX)\n" +
            "TTH = (MRX, KNT)\n" +
            "JXL = (QJD, HKK)\n" +
            "QKG = (XHK, RNK)\n" +
            "RXD = (SRV, CXH)\n" +
            "SBS = (CTL, BGB)\n" +
            "CSC = (JFC, XSH)\n" +
            "SKQ = (RNQ, QVN)\n" +
            "QSS = (QCS, QFP)\n" +
            "JJF = (QQX, QQX)\n" +
            "KMB = (LFP, FFR)\n" +
            "LMD = (RXD, NDN)\n" +
            "SSQ = (HMP, BGK)\n" +
            "GKL = (PGQ, NHK)\n" +
            "DMH = (KKJ, MTX)\n" +
            "RBD = (SGH, PKL)\n" +
            "JBG = (RLB, RRL)\n" +
            "XPR = (PHH, MXL)\n" +
            "PCH = (TJF, RCH)\n" +
            "SRN = (BJK, LLT)\n" +
            "RGV = (NFQ, HMC)\n" +
            "MPV = (NFM, CJK)\n" +
            "RLB = (JDH, TMT)\n" +
            "XQK = (CSJ, FRT)\n" +
            "TTX = (VJP, NCG)\n" +
            "GPB = (KNT, MRX)\n" +
            "XKH = (GPB, TTH)\n" +
            "XJP = (FBK, GRT)\n" +
            "STF = (XKH, QHQ)\n" +
            "LCN = (JKJ, SKQ)\n" +
            "SBL = (MNV, QFH)\n" +
            "BQT = (QBB, NMX)\n" +
            "DBS = (CMC, KFX)\n" +
            "BVR = (BSJ, NBP)\n" +
            "STV = (XFX, QGQ)\n" +
            "CDM = (QFQ, MBF)\n" +
            "NRK = (RRL, RLB)\n" +
            "QDT = (MQN, CGX)\n" +
            "JBL = (BMR, JVJ)\n" +
            "DBK = (HHV, KTD)\n" +
            "JNM = (JVL, KPM)\n" +
            "MPK = (QXQ, RHK)\n" +
            "NRT = (NSH, GRC)\n" +
            "CMH = (HFN, FXJ)\n" +
            "KFV = (HHT, JSK)\n" +
            "XCZ = (GSR, CNK)\n" +
            "GSR = (QQK, DHQ)\n" +
            "PPF = (QKJ, DRK)\n" +
            "BGQ = (KRM, SVX)\n" +
            "QGF = (QBQ, HJF)\n" +
            "SFZ = (NNM, MGL)\n" +
            "XHD = (NFD, PSS)\n" +
            "FTB = (TFM, CXQ)\n" +
            "XSS = (KSQ, BVF)\n" +
            "SGH = (XVG, PVQ)\n" +
            "NKC = (GRC, NSH)\n" +
            "RBP = (PQP, CMP)\n" +
            "BRR = (JGB, GVH)\n" +
            "PDT = (RLP, DXM)\n" +
            "GLV = (JTN, FVN)\n" +
            "XKJ = (KPM, JVL)\n" +
            "MQN = (XLG, BVK)\n" +
            "MRN = (LVR, MPK)\n" +
            "LNF = (HCT, DBS)\n" +
            "TLT = (MCP, JBC)\n" +
            "QVG = (NKC, NRT)\n" +
            "VGJ = (KJF, SBS)\n" +
            "PDB = (GVP, VGJ)\n" +
            "FRT = (FHJ, GQS)\n" +
            "GXN = (XVL, PPZ)\n" +
            "QHQ = (GPB, TTH)\n" +
            "DQR = (RFF, MFM)\n" +
            "TTQ = (JNC, BKP)\n" +
            "JTK = (CCQ, MBJ)\n" +
            "SLC = (QDG, BSP)\n" +
            "TDT = (TSP, SKL)\n" +
            "VGQ = (CKR, KPF)\n" +
            "TJJ = (PGD, RNC)\n" +
            "CXQ = (GGR, BVT)\n" +
            "FNC = (PGD, RNC)\n" +
            "JFQ = (DTG, GJL)\n" +
            "NPM = (GGT, BHB)\n" +
            "FQD = (MCD, DSJ)\n" +
            "TQF = (QGS, VVK)\n" +
            "SVX = (TLC, DDL)\n" +
            "TDX = (BVV, NGL)\n" +
            "MSV = (NCL, DTH)\n" +
            "GQQ = (BVB, LGS)\n" +
            "LNC = (PCQ, RVK)\n" +
            "BSP = (NSB, CSF)\n" +
            "MNR = (XTX, TRT)\n" +
            "PDQ = (GJM, TDL)\n" +
            "MBF = (CFT, STF)\n" +
            "QJD = (RQP, VGD)\n" +
            "CNM = (BPQ, CGG)\n" +
            "XLS = (GSS, GPD)\n" +
            "TFX = (NPM, GJF)\n" +
            "DLC = (BVV, NGL)\n" +
            "BVK = (LNF, KCF)\n" +
            "VGD = (DFF, XPK)\n" +
            "RGS = (LPN, NDF)\n" +
            "JRP = (HHB, LTN)\n" +
            "GDD = (VST, SVR)\n" +
            "BDN = (RPD, QQF)\n" +
            "XTX = (VMH, KKV)\n" +
            "NMN = (NCH, GLV)\n" +
            "CMC = (VGF, HLG)\n" +
            "NBF = (VVK, QGS)\n" +
            "LCV = (TFX, XNN)\n" +
            "BBC = (CTP, KKQ)\n" +
            "THR = (DRC, KMB)\n" +
            "GNT = (MTX, KKJ)\n" +
            "DVQ = (RTM, VDX)\n" +
            "NFQ = (VVX, VCD)\n" +
            "CKQ = (HMV, XPR)\n" +
            "FCG = (VGQ, LDR)\n" +
            "KRM = (TLC, DDL)\n" +
            "LTX = (NJH, CLL)\n" +
            "VDQ = (JKS, GNS)\n" +
            "XSC = (LLT, BJK)\n" +
            "HQB = (GBP, RFP)\n" +
            "VDX = (KHF, QPJ)\n" +
            "RPC = (VFR, MFJ)\n" +
            "QTC = (FFT, NFG)\n" +
            "HLM = (BSP, QDG)\n" +
            "GGR = (QVG, JSP)\n" +
            "XCK = (XTX, TRT)\n" +
            "QFP = (KVD, XPB)\n" +
            "LMV = (CSJ, FRT)\n" +
            "SKL = (HXL, MSV)\n" +
            "TVP = (DJH, BKC)\n" +
            "QML = (QKH, SMT)\n" +
            "MNV = (KDR, LGT)\n" +
            "HRC = (SBG, JVH)\n" +
            "BJM = (KXG, DQR)\n" +
            "TND = (DTG, GJL)\n" +
            "JJN = (FQD, CRH)\n" +
            "LSV = (NRK, JBG)\n" +
            "GBT = (CLK, XVF)\n" +
            "BGK = (QRN, BDN)\n" +
            "BLV = (LJC, VLN)\n" +
            "KXR = (CXQ, TFM)\n" +
            "CMR = (JHH, CKL)\n" +
            "XFQ = (MQL, XJP)\n" +
            "MTX = (RPC, RRK)\n" +
            "NJC = (GQQ, CQK)\n" +
            "FVB = (FNC, TJJ)\n" +
            "FBX = (KXJ, TGM)\n" +
            "GPP = (XDC, CSC)\n" +
            "NRB = (JRQ, TLQ)\n" +
            "RRK = (VFR, MFJ)\n" +
            "TKS = (JJN, DMB)\n" +
            "GJH = (XSC, SRN)\n" +
            "CFJ = (CQJ, VRD)\n" +
            "MFX = (LCV, MGX)\n" +
            "XTR = (QFP, QCS)\n" +
            "QGQ = (DKT, XSM)\n" +
            "CFZ = (GRJ, KPD)\n" +
            "JGB = (HRC, LRR)\n" +
            "RDJ = (DKC, NBQ)\n" +
            "GRS = (XQG, DPN)\n" +
            "JPS = (XKJ, JNM)\n" +
            "JSS = (LJJ, TDT)\n" +
            "QPJ = (RDM, MHR)\n" +
            "DCN = (SMN, GVQ)\n" +
            "PKL = (XVG, PVQ)\n" +
            "SXA = (HCB, QKG)\n" +
            "LTN = (HJP, HMK)\n" +
            "LVR = (QXQ, RHK)\n" +
            "HFN = (JPR, DRB)\n" +
            "JDH = (HKC, GGX)\n" +
            "MRX = (SHB, JDB)\n" +
            "LFP = (KPV, XTP)\n" +
            "DKP = (KXR, FTB)\n" +
            "XPG = (QNF, CDC)\n" +
            "MRH = (LDX, HQB)\n" +
            "XFX = (DKT, DKT)\n" +
            "KKX = (HDB, DQH)\n" +
            "SVR = (KFP, FTT)\n" +
            "VCJ = (QMN, BVR)\n" +
            "LQH = (MKL, LCC)\n" +
            "MJT = (QKH, SMT)\n" +
            "QRP = (QST, PVJ)\n" +
            "TMP = (MCP, JBC)\n" +
            "HLG = (PFS, VVQ)\n" +
            "LLV = (CMH, QTV)\n" +
            "QBB = (BLM, FTM)\n" +
            "CTV = (HTM, XFT)\n" +
            "DNT = (KFG, BRR)\n" +
            "XHK = (BRJ, QCB)\n" +
            "CJK = (CTD, CVD)\n" +
            "AAA = (JKJ, SKQ)\n" +
            "BXX = (GNT, DMH)\n" +
            "HCB = (RNK, XHK)\n" +
            "LNT = (QMN, BVR)\n" +
            "TGM = (NXP, JHN)\n" +
            "CQK = (LGS, BVB)\n" +
            "CJB = (RBV, QRP)\n" +
            "HDB = (NCV, LQR)\n" +
            "CNQ = (CTV, MQB)\n" +
            "BHN = (GDK, GDK)\n" +
            "DML = (JJF, DGK)\n" +
            "FVF = (KRH, BMQ)\n" +
            "TSP = (MSV, HXL)\n" +
            "QBG = (VLR, QJP)\n" +
            "KNT = (JDB, SHB)\n" +
            "FCS = (TGM, KXJ)\n" +
            "FVN = (JFQ, TND)\n" +
            "DHV = (FCG, BXS)\n" +
            "XPK = (VHV, THR)\n" +
            "BKP = (VDQ, HPT)\n" +
            "VST = (FTT, KFP)\n" +
            "DLS = (VVL, SXD)\n" +
            "FTR = (MBJ, CCQ)\n" +
            "MXL = (CRM, VQB)\n" +
            "DHP = (DHC, PQQ)\n" +
            "BXS = (LDR, VGQ)\n" +
            "DQL = (HDB, DQH)\n" +
            "TMT = (GGX, HKC)\n" +
            "PFC = (CJF, CFZ)\n" +
            "CTD = (XGF, NBH)\n" +
            "VFR = (VFF, XHD)\n" +
            "RQP = (DFF, XPK)\n" +
            "LTK = (NFM, CJK)\n" +
            "MTS = (LJJ, TDT)\n" +
            "HHT = (FVF, VLM)\n" +
            "MNC = (QBB, NMX)\n" +
            "FKF = (LPN, NDF)\n" +
            "LHD = (QJD, HKK)\n" +
            "JFC = (MJV, MJV)\n" +
            "XXX = (LMD, LGH)\n" +
            "NCV = (HFF, FHP)\n" +
            "PSS = (BQP, NJF)\n" +
            "NQH = (XLS, FQG)\n" +
            "VGF = (VVQ, PFS)\n" +
            "SKV = (MNV, QFH)\n" +
            "LJC = (KTF, PJQ)\n" +
            "SNX = (XDC, CSC)\n" +
            "NDN = (CXH, SRV)\n" +
            "HKC = (MTS, JSS)\n" +
            "PHH = (CRM, VQB)\n" +
            "FLN = (GJM, TDL)\n" +
            "VVK = (PHD, GKL)\n" +
            "MQS = (RKN, PFC)\n" +
            "LRR = (JVH, SBG)\n" +
            "JKJ = (RNQ, QVN)\n" +
            "XVL = (HCB, QKG)\n" +
            "NPD = (SNX, GPP)\n" +
            "KTD = (QDJ, KHK)\n" +
            "TDL = (RGV, GLB)\n" +
            "SNF = (HLJ, XXX)\n" +
            "MBJ = (JMK, BDB)\n" +
            "GDK = (RKN, RKN)\n" +
            "SFV = (DLS, PLR)\n" +
            "KNF = (BGK, HMP)\n" +
            "XVF = (QXB, BGQ)\n" +
            "RMH = (HLJ, XXX)\n" +
            "LPF = (XVP, NHB)\n" +
            "NSH = (KQJ, MBT)\n" +
            "QNM = (GXV, FRM)\n" +
            "LTM = (BKL, SKR)\n" +
            "GJL = (TCX, LVM)\n" +
            "KXG = (RFF, MFM)\n" +
            "TFG = (DHV, VFQ)\n" +
            "HPX = (MBF, QFQ)\n" +
            "GJM = (GLB, RGV)\n" +
            "VCD = (TVH, GCM)\n" +
            "NLN = (NKL, CMR)\n" +
            "XPB = (TVP, QRT)\n" +
            "FRJ = (XTC, TGP)\n" +
            "FHF = (KSB, CMM)\n" +
            "KVK = (FFT, NFG)\n" +
            "GRC = (MBT, KQJ)\n" +
            "BHR = (XVF, CLK)\n" +
            "HLJ = (LMD, LGH)\n" +
            "LLT = (JPS, BKQ)\n" +
            "DKC = (BPL, HGH)\n" +
            "BPL = (STV, VDL)\n" +
            "SHB = (FBX, FCS)\n" +
            "FQG = (GPD, GSS)\n" +
            "TLN = (RCQ, RBP)\n" +
            "LDR = (CKR, KPF)\n" +
            "NCH = (JTN, FVN)\n" +
            "CMM = (BPH, MXS)\n" +
            "RLP = (LPF, LSS)\n" +
            "CKR = (SHL, NQH)\n" +
            "TJF = (FDT, CCB)\n" +
            "BVD = (DLS, PLR)\n" +
            "QQK = (XGR, NMN)\n" +
            "KPV = (QBC, LLD)\n" +
            "HFF = (NNH, CSS)\n" +
            "DKG = (PQQ, DHC)\n" +
            "TQZ = (DMB, JJN)\n" +
            "MLC = (VNN, XPG)\n" +
            "DHX = (PDB, KQT)\n" +
            "BHB = (XHP, BGG)\n" +
            "RHK = (QDT, JLV)\n" +
            "PDG = (PJM, TDD)\n" +
            "FHJ = (CFJ, GVR)\n" +
            "DJG = (KSD, DHX)\n" +
            "RFF = (MXN, PMM)\n" +
            "MQB = (HTM, XFT)\n" +
            "NSB = (BTC, MLD)\n" +
            "DDL = (FRJ, TPQ)\n" +
            "XDB = (VDX, RTM)\n" +
            "NJX = (KFG, BRR)\n" +
            "JHH = (MVX, MCB)\n" +
            "DFF = (THR, VHV)\n" +
            "GMA = (JJN, DMB)\n" +
            "SHP = (BKL, SKR)\n" +
            "QXB = (KRM, SVX)";
}

