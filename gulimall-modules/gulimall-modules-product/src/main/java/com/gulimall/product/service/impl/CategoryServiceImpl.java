package com.gulimall.product.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.CategoryMapper;
import com.gulimall.product.domain.Category;
import com.gulimall.product.service.ICategoryService;

/**
 * 商品三级分类Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-11
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements ICategoryService
{
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询商品三级分类
     * 
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public Category selectCategoryByCatId(Long catId)
    {
        return categoryMapper.selectCategoryByCatId(catId);
    }

    /**
     * 查询商品三级分类列表
     * 
     * @param category 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<Category> selectCategoryList(Category category)
    {
        return categoryMapper.selectCategoryList(category);
    }

    /**
     * 新增商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    @Override
    public int insertCategory(Category category)
    {
        return categoryMapper.insertCategory(category);
    }

    /**
     * 修改商品三级分类
     * 
     * @param category 商品三级分类
     * @return 结果
     */
    @Override
    public int updateCategory(Category category)
    {
        return categoryMapper.updateCategory(category);
    }

    /**
     * 批量删除商品三级分类
     * 
     * @param catIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByCatIds(Long[] catIds)
    {
        return categoryMapper.deleteCategoryByCatIds(catIds);
    }

    /**
     * 删除商品三级分类信息
     * 
     * @param catId 商品三级分类主键
     * @return 结果
     */
    @Override
    public int deleteCategoryByCatId(Long catId)
    {
        return categoryMapper.deleteCategoryByCatId(catId);
    }

    @Override
    public List<Category> listWithTree() {
        //1、查询出所有分类
        List<Category> entities = super.baseMapper.selectList(null);

        //2、组装成父子的树形结构

        //2.1)、找到所有一级分类
        List<Category> levelMenus = entities.stream()
                .filter(e -> e.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildrens(menu, entities));
                    return menu;
                })
                .sorted((menu, menu2) -> {
                    return (menu.getSort() == null ? 0 : menu.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                })
                .collect(Collectors.toList());

        return levelMenus;
    }

    //递归查找所有菜单的子菜单
    private List<Category> getChildrens(Category root, List<Category> all) {

        List<Category> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            //1、找到子菜单(递归)
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu, menu2) -> {
            //2、菜单的排序
            return (menu.getSort() == null ? 0 : menu.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return children;

    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 检查当前删除的菜单，是否被别的地方引用
//        List<CategoryBrandRelationEntity> categoryBrandRelation =
//                categoryBrandRelationService.list(new QueryWrapper<CategoryBrandRelationEntity>().in("catelog_id", asList));

//        if (categoryBrandRelation.size() == 0) {
            //逻辑删除
            baseMapper.deleteBatchIds(asList);
//        } else {
//            throw new RuntimeException("该菜单下面还有属性，无法删除!");
//        }
    }


}
