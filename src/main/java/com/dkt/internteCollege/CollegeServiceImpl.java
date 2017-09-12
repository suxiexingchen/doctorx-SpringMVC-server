package com.dkt.internteCollege;

import com.dkt.entity.TVAct;
import com.dkt.entity.TVProgram;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 馒头花卷儿
 * @Description:
 * @create 2017-09-09
 */
@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private TVProgramDao tvProgramDao;
    @Autowired
    private TVActDao tvActDao;

    public List<ProgramBeanP0001<TVActBeanP0001>> getProgramAndAct(){

        List<ProgramBeanP0001<TVActBeanP0001>> list=new ArrayList<>();

        List<TVProgram> listTVProgram = tvProgramDao.getProgramList();

        for (TVProgram tp:listTVProgram) {
            ProgramBeanP0001 programBeanP0001=new ProgramBeanP0001();
            BeanUtils.copyProperties(tp, programBeanP0001);
            list.add(programBeanP0001);

            List<TVActBeanP0001> tvactList = new ArrayList<>();
            if (null!=tp.getProgramId()){
                List<TVAct> tvActList = tvActDao.getTVActListByProgramId(tp.getProgramId());
                for (TVAct act:tvActList) {
                    TVActBeanP0001 tvActBeanP0001=new TVActBeanP0001();
                    BeanUtils.copyProperties(act,tvActBeanP0001);
                    if (null!=act.getCommitTime()&&!act.getCommitTime().equals("")){
                        tvActBeanP0001.setCommitTime(act.getCommitTime().getTime());
                    }

                    tvactList.add(tvActBeanP0001);
                }
            }
            programBeanP0001.setTvactList(tvactList);

        }

        return list;
    }
}
