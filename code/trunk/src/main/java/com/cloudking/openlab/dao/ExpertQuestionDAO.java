package com.cloudking.openlab.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloudking.openlab.BaseDAO;
import com.cloudking.openlab.CloudContext;
import com.cloudking.openlab.PageInfo;
import com.cloudking.openlab.entity.ExpertQuestionEntity;
import com.cloudking.openlab.util.Constant;
import com.cloudking.openlab.vo.ExpertQuestionVO;

@Repository("expertQuestionDAO")
public class ExpertQuestionDAO extends BaseDAO<ExpertQuestionEntity> {
    /**
     * 查询问答
     * 
     * @param isJd
     * @return
     * @throws SQLException
     */
    public List<ExpertQuestionEntity> queryExpertQuestion(Byte isJd) throws SQLException {
        String sql;
        if (isJd < 1) {
            sql = "from ExpertQuestionEntity eq_ where eq_.type<>:thetype order by eq_.id asc";
            return pageQuery(sql, "thetype",Constant.EXPERT_QUESTION_REFUSE,0, 7);
        } else {
            sql = "from ExpertQuestionEntity eq_ where eq_.type=:isjd order by eq_.id asc";
            return list(sql, "isjd", isJd);
        }
    }

    /**
     * 根据当前登录的用户不同，显示出有关此用户的问题
     * 
     * @return
     * @throws SQLException
     */
    public List<ExpertQuestionEntity> queryLoginUserQuestion(CloudContext<ExpertQuestionVO> cloudContext)
                    throws SQLException {
        // 查询所有
        StringBuffer resultHQL = new StringBuffer(
                        "select eqe_ from ExpertQuestionEntity eqe_ where 1=1");

        // 记录数目统计
        StringBuffer countHQL = new StringBuffer(
                        "select count(eqe_.id) from  ExpertQuestionEntity as eqe_ where 1=1");
        List<String> paramNames = new ArrayList<String>();
        List<Object> paramValues = new ArrayList<Object>();
        
        if (cloudContext.getVo().getTitle()!=null) {
        	 resultHQL.append(" and eqe_.title like :tiTle ");
             countHQL.append(" and eqe_.title like :tiTle ");
             paramNames.add("tiTle");
             paramValues.add(cloudContext.getVo().getTitle());
		}
        if (cloudContext.getIntegerParam("expertid") != null) {
            resultHQL.append(" and eqe_.expert.id=:expertId ");
            countHQL.append(" and eqe_.expert.id=:expertId  ");
            paramNames.add("expertId");
            paramValues.add(cloudContext.getLongParam("expertid"));
        }
        if (cloudContext.getIntegerParam("userid") != null) {
            resultHQL.append(" and eqe_.questioner.id=:userId ");
            countHQL.append(" and eqe_.questioner.id=:userId  ");
            paramNames.add("userId");
            paramValues.add(cloudContext.getLongParam("userid"));
        }
        // 排序
        resultHQL.append("  order by  eqe_.id desc ");
        // 查询总页数
        Integer count = Integer.parseInt(uniqueResultObject(countHQL.toString(),
                        paramNames.toArray(paramNames.toArray(new String[paramNames.size()])),
                        paramValues.toArray(new Object[paramValues.size()])).toString());
        List<ExpertQuestionEntity> voList = new ArrayList<ExpertQuestionEntity>();
        if (count > 0) {
            // 分页查询
            voList = pageQuery(resultHQL.toString(), paramNames.toArray(paramNames
                            .toArray(new String[paramNames.size()])), paramValues
                            .toArray(new Object[paramValues.size()]), cloudContext.getPageInfo().getStart(),
                            cloudContext.getPageInfo().getEachPageData());
        }

        cloudContext.getPageInfo().setDataCount(count);
        return voList;
    }

    /**
     * 首页登录，查询出自己未处理的问答的条目
     * 
     * @return
     * @throws SQLException
     */
    public int LoginUserQuestions(Long userId) throws SQLException {
        String hql = "select count(u_.id) from UserEntity u_ left join u_.receiveQuestions rq_ left join u_.sendQuestions sq_ left join rq_.answers ra_ left join sq_.answers sa_ where (rq_.isView=false or (ra_.isView=false and ra_.answerer.id<>:userId) or (sa_.isView=false and sa_.answerer.id<>:userId)) and u_.id=:userId";
        return Integer.parseInt(uniqueResultObject(hql, "userId", userId).toString());
    }
    /**
     * 分页显示
     * @param pageInfo
     * @return
     * @throws SQLException
     */
	public List<ExpertQuestionEntity> query(PageInfo pageInfo) throws SQLException {
		// 分页查询
		StringBuilder queryQL = new StringBuilder(
		"select eq_ from ExpertQuestionEntity eq_ where eq_.type<>:thisType");
		List<String> paramNames = new ArrayList<String>();
		List<Object> paramValues = new ArrayList<Object>();
		if (true) {
			paramNames.add("thisType");
			paramValues.add(Constant.EXPERT_QUESTION_REFUSE);
		}
		// 排序
		queryQL.append(" order by eq_.id asc");
		// 分页查询
		List<?> queryResult = pageQuery(queryQL.toString(), paramNames,
				paramValues, pageInfo);
		return (List<ExpertQuestionEntity> )queryResult;
	}
}
