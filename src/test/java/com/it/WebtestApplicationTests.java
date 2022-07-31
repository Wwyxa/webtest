package com.it;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.dao.BrandDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebtestApplicationTests {

    @Autowired
    private BrandDao brandDao;

    @Test
    void testSelectByPage() {
        IPage page=new Page(1,3);
        brandDao.selectPage(page, null);
        System.out.println(page.getRecords());
    }

}
