/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mynah.mesh.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;
import java.sql.Clob;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Currency;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mynah.mesh.annotation.Dictionary;
import org.mynah.mesh.annotation.Cell;
import org.mynah.mesh.annotation.Sheet;

@Sheet(header = "default", index = 0, title = "维修项目导入")
public class TmItem {
    @Cell(column = 0, title = "编号")
    @NotNull
    private Long id;
    private Short itemId;
    @Cell(column = 1, title = "数量")
    @Max(500)
    @Min(10)
    private Integer amount;
    @Cell(column = 2, title = "类型")
    @Dictionary("type")
    private Integer type;
    @Cell(column = 3, title = "分数")
    @Digits(fraction = 3, integer = 2)
    private Float score;
    @Cell(column = 4, title = "工时")
    @Digits(fraction = 5, integer = 5)
    private Double labourHour;
    private Character character;
    @Cell(column = 5, title = "是否有效")
    @Dictionary("isValid")
    private Boolean status;
    private Byte byteData;
    @Cell(column = 6, title = "内容")
    @Size(max = 2000, min = 100)
    private String content;
    @Cell(column = 7, title = "创建时间")
    private Date createDate;
    private BigDecimal bigDecimal;
    private byte[] byteArray;
    private Object object;
    private Time time;
    private Timestamp timestamp;
    private Calendar calendar;
    private Clob Clob;
    private Blob Blob;
    private Locale locale;
    private TimeZone timeZone;
    private Currency Currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getItemId() {
        return itemId;
    }

    public void setItemId(Short itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Double getLabourHour() {
        return labourHour;
    }

    public void setLabourHour(Double labourHour) {
        this.labourHour = labourHour;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Byte getByteData() {
        return byteData;
    }

    public void setByteData(Byte byteData) {
        this.byteData = byteData;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public void setByteArray(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Clob getClob() {
        return Clob;
    }

    public void setClob(Clob clob) {
        Clob = clob;
    }

    public Blob getBlob() {
        return Blob;
    }

    public void setBlob(Blob blob) {
        Blob = blob;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Currency getCurrency() {
        return Currency;
    }

    public void setCurrency(Currency currency) {
        Currency = currency;
    }

}
