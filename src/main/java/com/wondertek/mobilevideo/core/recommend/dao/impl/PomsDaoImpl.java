package com.wondertek.mobilevideo.core.recommend.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wondertek.mobilevideo.core.base.GenericDaoHibernate;
import com.wondertek.mobilevideo.core.recommend.dao.PomsDao;
import com.wondertek.mobilevideo.core.recommend.vo.PrdContInfo;
import com.wondertek.mobilevideo.core.util.StringUtil;

public class PomsDaoImpl extends GenericDaoHibernate<PrdContInfo,Long> implements PomsDao {

	public PomsDaoImpl() {
		super(PrdContInfo.class);
	}

	@Override
	public List<PrdContInfo> getInfoByPrdContIds(List<Long> proContIds) {

		Session session = this.getSession();
		String sql = "select pc.prd_cont_id,pc.content_id,pc.bc_status,pc.pub_status,pc.publish_no_voms_status,pc.form_type,pc.create_time,pc.update_time, "
				+ "pi.name as prdinfoname, "
				+ "c.cp_id,c.name,c.display_name "
				+ "from prd_cont pc left join prd_info pi on pi.prdinfoid = pc.prd_info_id "
				+ "left join content c on c.content_id = pc.content_id "
				+ "where ";

		if (proContIds != null) {
			if (proContIds.size() == 1) {
				 sql += "pc.prd_cont_id = ？";

			}else if(proContIds.size() > 1) {
				 sql += "pc.prd_cont_id in(:ids)";
			}
			Query query = session.createSQLQuery(sql);			
			if (proContIds.size() == 1) {
				query.setParameter(0, proContIds.get(0));
			} else if (proContIds.size() > 1) {
				query.setParameterList("ids", proContIds);
			}
			List<Object[]> list = query.list();
			//在得到的list中解析出List<PrdContInfo>
			List<PrdContInfo> prdContInfos = new ArrayList<PrdContInfo>();
			for (Object[] o : list) {
				prdContInfos.add(
				new PrdContInfo(
					StringUtil.nullToLong(o[0]),
					StringUtil.null2Str(o[1]),
					(o[2] == null ? null : StringUtil.nullToInteger(o[2])),
					(o[3] == null ? null : StringUtil.nullToInteger(o[3])),
					(o[4] == null ? null : StringUtil.nullToInteger(o[4])),
					StringUtil.null2Str(o[5]),
					(Date)(o[6]),
					(Date)(o[7]),
					StringUtil.null2Str(o[8]),
					StringUtil.null2Str(o[9]),
					StringUtil.null2Str(o[10]),
					StringUtil.null2Str(o[11])
				));
			}
			releaseSession(session);
			return prdContInfos;
		} else {
			//如果proContIds 为null 则返回null
			return null;
		}
	}
}
