package com.example.demo1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andManagerCodeIsNull() {
            addCriterion("managerCode is null");
            return (Criteria) this;
        }

        public Criteria andManagerCodeIsNotNull() {
            addCriterion("managerCode is not null");
            return (Criteria) this;
        }

        public Criteria andManagerCodeEqualTo(String value) {
            addCriterion("managerCode =", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeNotEqualTo(String value) {
            addCriterion("managerCode <>", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeGreaterThan(String value) {
            addCriterion("managerCode >", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("managerCode >=", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeLessThan(String value) {
            addCriterion("managerCode <", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeLessThanOrEqualTo(String value) {
            addCriterion("managerCode <=", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeLike(String value) {
            addCriterion("managerCode like", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeNotLike(String value) {
            addCriterion("managerCode not like", value, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeIn(List<String> values) {
            addCriterion("managerCode in", values, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeNotIn(List<String> values) {
            addCriterion("managerCode not in", values, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeBetween(String value1, String value2) {
            addCriterion("managerCode between", value1, value2, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerCodeNotBetween(String value1, String value2) {
            addCriterion("managerCode not between", value1, value2, "managerCode");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordIsNull() {
            addCriterion("managerPassword is null");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordIsNotNull() {
            addCriterion("managerPassword is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordEqualTo(String value) {
            addCriterion("managerPassword =", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordNotEqualTo(String value) {
            addCriterion("managerPassword <>", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordGreaterThan(String value) {
            addCriterion("managerPassword >", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("managerPassword >=", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordLessThan(String value) {
            addCriterion("managerPassword <", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordLessThanOrEqualTo(String value) {
            addCriterion("managerPassword <=", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordLike(String value) {
            addCriterion("managerPassword like", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordNotLike(String value) {
            addCriterion("managerPassword not like", value, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordIn(List<String> values) {
            addCriterion("managerPassword in", values, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordNotIn(List<String> values) {
            addCriterion("managerPassword not in", values, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordBetween(String value1, String value2) {
            addCriterion("managerPassword between", value1, value2, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andManagerPasswordNotBetween(String value1, String value2) {
            addCriterion("managerPassword not between", value1, value2, "managerPassword");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNull() {
            addCriterion("createDateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIsNotNull() {
            addCriterion("createDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeEqualTo(Date value) {
            addCriterion("createDateTime =", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotEqualTo(Date value) {
            addCriterion("createDateTime <>", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThan(Date value) {
            addCriterion("createDateTime >", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createDateTime >=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThan(Date value) {
            addCriterion("createDateTime <", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createDateTime <=", value, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeIn(List<Date> values) {
            addCriterion("createDateTime in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotIn(List<Date> values) {
            addCriterion("createDateTime not in", values, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeBetween(Date value1, Date value2) {
            addCriterion("createDateTime between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andCreateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createDateTime not between", value1, value2, "createDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIsNull() {
            addCriterion("updateDateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIsNotNull() {
            addCriterion("updateDateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeEqualTo(Date value) {
            addCriterion("updateDateTime =", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotEqualTo(Date value) {
            addCriterion("updateDateTime <>", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeGreaterThan(Date value) {
            addCriterion("updateDateTime >", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateDateTime >=", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeLessThan(Date value) {
            addCriterion("updateDateTime <", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateDateTime <=", value, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeIn(List<Date> values) {
            addCriterion("updateDateTime in", values, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotIn(List<Date> values) {
            addCriterion("updateDateTime not in", values, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeBetween(Date value1, Date value2) {
            addCriterion("updateDateTime between", value1, value2, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateDateTime not between", value1, value2, "updateDateTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}