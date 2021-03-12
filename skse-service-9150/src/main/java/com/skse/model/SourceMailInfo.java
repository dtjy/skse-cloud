package com.skse.model;

import java.io.Serializable;

public class SourceMailInfo implements Serializable {
    private String sourceMail;

    private String password;

    private String host;
    private Integer status;
    private String smtpPort;

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return source_mail
     */
    public String getSourceMail() {
        return sourceMail;
    }

    /**
     * @param sourceMail
     */
    public void setSourceMail(String sourceMail) {
        this.sourceMail = sourceMail;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }
}