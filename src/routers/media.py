from fastapi import APIRouter, Depends
from sqlmodel import Session, select
from typing import List
from app.models import Media
from app.schemas import MediaCreate 
from app.database import get_session

router = APIRouter(prefix="/media", tags=["Media"])

@router.get("/", response_model=List[Media])
def list_all_media(media_type: str = None, session: Session = Depends(get_session)):
    query = select(Media)
    if media_type:
        query = query.where(Media.media_type == media_type) 
    return session.exec(query).all()

@router.post("/")
def create_media(media: MediaCreate, session: Session = Depends(get_session)):
    db_media = Media(**media.dict())
    session.add(db_media)
    session.commit()
    session.refresh(db_media)
    return db_media

class User(SQLModel):
    id Optional[int] = Field(default=None, primary_key=True)
