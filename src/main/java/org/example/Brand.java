package org.example;

public class Brand {
    // id 主键
    private Integer id;
    // 品牌名称
    private String brand_name;
    // 企业名称
    private String company_name;
    // 排序字段
    private Integer ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status;

    public Brand() {
    }

    public Brand(Integer id, String brand_name, String company_name, Integer ordered, String description, Integer status) {
        this.id = id;
        this.brand_name = brand_name;
        this.company_name = company_name;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return brand_name
     */
    public String getBrand_name() {
        return brand_name;
    }

    /**
     * 设置
     * @param brand_name
     */
    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    /**
     * 获取
     * @return company_name
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * 设置
     * @param company_name
     */
    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    /**
     * 获取
     * @return ordered
     */
    public Integer getOrdered() {
        return ordered;
    }

    /**
     * 设置
     * @param ordered
     */
    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "Brand{id = " + id + ", brand_name = " + brand_name + ", company_name = " + company_name + ", ordered = " + ordered + ", description = " + description + ", status = " + status + "}";
    }
}
