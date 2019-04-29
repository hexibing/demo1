package com.example.demo1.model;

import com.example.demo1.util.SHA256Util;
import com.example.demo1.util.StringUtil;

import java.io.Serializable;
import java.util.Date;

public class Manager implements Serializable {
    private Long id;

    private String managerCode;

    private String managerPassword;

    private String salt;

    private Date createDateTime;

    private Date updateDateTime;

    private String description;

    private static final long serialVersionUID = 1L;

    public Manager(Long id, String managerCode, String managerPassword, String salt, Date createDateTime, Date updateDateTime, String description) {
        this.id = id;
        this.managerCode = managerCode;
        this.managerPassword = managerPassword;
        this.salt = salt;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.description = description;
    }

    public Manager() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode == null ? null : managerCode.trim();
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", managerCode=").append(managerCode);
        sb.append(", managerPassword=").append(managerPassword);
        sb.append(", salt=").append(salt);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", updateDateTime=").append(updateDateTime);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Manager other = (Manager) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getManagerCode() == null ? other.getManagerCode() == null : this.getManagerCode().equals(other.getManagerCode()))
            && (this.getManagerPassword() == null ? other.getManagerPassword() == null : this.getManagerPassword().equals(other.getManagerPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getCreateDateTime() == null ? other.getCreateDateTime() == null : this.getCreateDateTime().equals(other.getCreateDateTime()))
            && (this.getUpdateDateTime() == null ? other.getUpdateDateTime() == null : this.getUpdateDateTime().equals(other.getUpdateDateTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getManagerCode() == null) ? 0 : getManagerCode().hashCode());
        result = prime * result + ((getManagerPassword() == null) ? 0 : getManagerPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getCreateDateTime() == null) ? 0 : getCreateDateTime().hashCode());
        result = prime * result + ((getUpdateDateTime() == null) ? 0 : getUpdateDateTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    public boolean validatePassword(String inputPassword) {
        String inputSha256 = getDBEncryptedPassword(inputPassword, this.getSalt());
        if(inputSha256.equalsIgnoreCase(this.getManagerPassword())) {
            return true;
        }else {
            return false;
        }
    }

    public String getDBEncryptedPassword(String inputPassword, String salt) {
        if(StringUtil.isNil(inputPassword)) {
            return null;
        }
        //兼容处理，如果客户端传过来的是长度大于30的，就是SHA256后的密文，否则就是明文
        String sha256 = inputPassword;
        if(inputPassword.length() <= 30) {
            sha256 = SHA256Util.getSHA256Str(inputPassword);
        }

        return SHA256Util.getSHA256Str(sha256 + salt);
    }



}