package com.juran.examplemovie.client.bean.response;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.juran.examplemovie.client.bean.domain.D3CaseRetrieveRsp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author xiaolan.hou D3CaseSearchRsp
 * @version 2016年8月15日 下午2:39:35
 *
 */
@XmlRootElement
public class D3CaseSearchRsp extends BaseSearchRsp implements Serializable {
	private static final long serialVersionUID = 5094159719479513954L;

	@XmlAttribute(name = "cases")
	@ApiModelProperty(value = "3D案例集合", name = "cases")
	private List<D3CaseRetrieveRsp> cases;

	public D3CaseSearchRsp() {
		super();
	}

	public List<D3CaseRetrieveRsp> getCases() {
		return cases;
	}

	public void setCases(List<D3CaseRetrieveRsp> cases) {
		this.cases = cases;
	}

}
