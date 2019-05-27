package com.crm.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Fenye<E> {
private Integer page;
private Integer pageSize;
private Integer count;
private List<E> rows;
private E shiti;
public Integer getPage() {
	return page;
}
public void setPage(Integer page) {
	this.page = page;
}
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public List<E> getRows() {
	return rows;
}
public void setRows(List<E> rows) {
	this.rows = rows;
}
public E getShiti() {
	return shiti;
}
public void setShiti(E shiti) {
	this.shiti = shiti;
}
@Override
public String toString() {
	return "Fenye [page=" + page + ", pageSize=" + pageSize + ", count=" + count + ", rows=" + rows + ", shiti=" + shiti
			+ "]";
}


}
