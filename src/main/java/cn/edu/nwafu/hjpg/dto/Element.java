package cn.edu.nwafu.hjpg.dto;

import lombok.Data;

@Data
public class Element {
    // 物质编码
    private String id;
    // 中文名称
    private String chineseName;
    // 中文其他名称
    private String chineseOtherName;
    // 英文名称
    private String englishName;
    //英文其他名称
    private String englishOtherName;
    // IUPAC名称
    private String iupacName;
    // CAS号
    private String casNo;
    // SMILES码
    private String smilesCode;
    // 分子式
    private String molecularFormula;
    // 相对分子质量
    private Double xdfzzl;
    //TODO: 结构式,表示方法待定
    private String structure;
    // 饱和蒸汽压
    private String lhsxbBhzqyKeyValue;
    // 水溶解度
    private String lhsxbSrjdKeyValue;


}
