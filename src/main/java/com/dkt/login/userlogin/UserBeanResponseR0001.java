package com.dkt.login.userlogin;

/**
 * @author 馒头花卷儿
 * @Description:返回参数
 * @create 2017-09-18
 */
public class UserBeanResponseR0001 {

    /**
     * 操作员ID, 暂做主键.
     */
    private String userId;

    /**
     *名字
     */
    private String name;

    /**
     *性别 1男 2女
     */
    private Integer sex;

    /**
     *通讯地址
     */
    private String address;

    /**
     *病情描述
     */
    private String illness;

    /**
     *所属社区ID
     */
    private Integer communityId;

    /**
     *是否签约家庭医生 0 未签约 1签约
     */
    private Integer isSignatory;

    /**
     *头像地址
     */
    private String headPic;

    /**
     *联系电话
     */
    private String phoneNumber;

    /**
     * 通话号
     * @return
     */
    private String tvn;

    /**
     * 年龄
     * @return
     */
    private String age;

    /**
     * 身份证
     * @return
     */
    private String idCard;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getIsSignatory() {
        return isSignatory;
    }

    public void setIsSignatory(Integer isSignatory) {
        this.isSignatory = isSignatory;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTvn() {
        return tvn;
    }

    public void setTvn(String tvn) {
        this.tvn = tvn;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
