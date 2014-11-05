package com.mx.popcorn.controller.web;

import com.mx.popcorn.base.ModelDrivenBaseAction;
import com.mx.popcorn.domain.Movie;
import com.mx.popcorn.domain.MovieType;
import com.mx.popcorn.domain.MovieVersion;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2014-10-28.
 */
@Controller
@Scope("prototype")
@ParentPackage("default")
@Namespace("/movie")
public class MovieAction  extends ModelDrivenBaseAction<Movie> {

    private static final String ACTION_NAME_SPACE = "MovieIndex";
    private String[] type;
    private String[] version;
    private Long movieId;


    /**
     * 电影列表主页
     * @return
     */
    @Action(value = "index", results = @Result(location = "/WEB-INF/jsp/customer/movie/movieList.jsp"))
    public String index(){
        try {
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 上传电影的UI界面
     * @return
     */
    @Action(value = "/manage/movie/addMovieUI",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/manage/movie/addMovieUI.jsp")})
    public String addMovieUI(){
        try{
            getActionContext().put("movieType", typeService.getAllMovieType());
            getActionContext().put("movieVersion", typeService.getAllMovieVersion());
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 上传电影
     * @return
     */
    @Action(value = "/manage/movie/publishMovie",
            results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/manage/index.jsp"),
                                @Result(name = INPUT, location = "/WEB-INF/jsp/manage/movie/addMovieUI.jsp")})
    public String publishMovie(){
        try{
            Set<MovieType> types = new HashSet<MovieType>();
           for(String typeId : type){
               MovieType typeItem = typeService.getMovieType(Long.valueOf(typeId));
               if (typeItem != null)
                    types.add(typeItem);
           }
            model.setMovieTypes(types);

            Set<MovieVersion> versions = new HashSet<MovieVersion>();
            for (String versionId : version){
                MovieVersion versionItem = typeService.getMovieVersion(Long.valueOf(versionId));
                if (versionItem != null)
                    versions.add(versionItem);
            }
            model.setMovieVersions(versions);

            movieService.publishMovie(model);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }


    @Action(value = "showMovieInfo", results = {@Result(name = SUCCESS, location = "/WEB-INF/jsp/customer/movie/movieInformation.jsp")})
    public String showMovieInfo(){
        try {
            if (movieId == null)
                return FIND_FAILURE;
            Movie movie = movieService.getMovie(movieId);
            if (movie == null)
                return FIND_FAILURE;
            getActionContext().put("movie", movie);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ERROR;
        }
    }

    /**
     * 发布影片的数据初步效验
     */
    public void publishMovieValidate(){
        if (type.length <= 0)
            addFieldError("movieType", "至少一个有一个选择");
        if (version.length <= 0)
            addFieldError("movieVersion", "至少一个有一个选择");
    }


    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public static String getActionNameSpace() {
        return ACTION_NAME_SPACE;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public void setVersion(String[] version) {
        this.version = version;
    }
}
