from fastapi import APIRouter, Depends, HTTPException
from sqlmodel import Session, select
from app.models import TVShow
from app.schemas import TVShowCreate, TVShowUpdate
from app.database import get_session

router = APIRouter(prefix="/tv", tags=["TV Shows"])

@router.post("/")
def create_tvshow(tv: TVShowCreate, session: Session = Depends(get_session)):
    db_tv = TVShow(**tv.dict(), media_type="tv")
    session.add(db_tv)
    session.commit()
    session.refresh(db_tv)
    return db_tv

@router.get("/")
def list_tvshows(session: Session = Depends(get_session)):
    return session.exec(select(TVShow)).all()

@router.get("/{tv_id}")
def get_tvshow(tv_id: int, session: Session = Depends(get_session)):
    tv = session.get(TVShow, tv_id)
    if not tv:
        raise HTTPException(404, "TV Show not found")
    return tv

@router.put("/{tv_id}")
def update_tv(tv_id: int, tv_update: TVShowUpdate, session: Session = Depends(get_session)):
    tv = session.get(TVShow, tv_id)
    if not TVShow: 
        raise HTTPException(status_code=404, detail="TV Show not found")

    for key, value in tv_update.dict(exclude_unset=True).items():
        setattr(tv, key, value)

    session.add(tv)
    session.commit()
    session.refresh(tv)
    return tv 

@router.delete("/{tv_id}")
def delete_tvshow(tv_id: int, session: Session = Depends(get_session)):
    tv = session.get(TVShow, tv_id)
    if not tv:
        raise HTTPException(404, "TV Show not found")
    session.delete(tv)
    session.commit()
    return {"message": "Deleted"}


